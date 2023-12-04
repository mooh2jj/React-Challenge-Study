package auth.authserver.member;

import auth.authserver.jwt.JwtTokenProvider;
import auth.authserver.jwt.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final RolesRepository rolesRepository;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;

    public void saveMember(String email, String password, String name, String role){
        if(memberRepository.existsByEmail(email)){
            throw new RuntimeException("duplicated email");
        }
        memberRepository.save(new Member(email, passwordEncoder.encode(password), name));
        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new RuntimeException(email+" not found !"));
        rolesRepository.save(new Roles(null, member, role));
    }

    @Transactional
    public TokenInfo login(String email, String password) throws RuntimeException{
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return jwtTokenProvider.generateToken(authentication);
    }
}
