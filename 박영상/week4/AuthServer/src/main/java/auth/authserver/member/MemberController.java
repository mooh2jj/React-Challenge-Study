package auth.authserver.member;

import auth.authserver.jwt.TokenInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/join")
    public String save(@RequestBody @Valid MemberDto memberDto){
        try {
            memberService.saveMember(memberDto.getEmail(), memberDto.getPassword(), memberDto.getName(), memberDto.getRole());
        }catch (RuntimeException e){
            log.error(e.getMessage());
            return e.getMessage();
        }
        return "join success";
    }

    @PostMapping(value = "/login")
    public TokenInfo login(@RequestBody @Valid LoginDto loginDto){
        try {
            return memberService.login(loginDto.getEmail(), loginDto.getPassword());
        }catch (RuntimeException e){
            log.error(e.getMessage());
            return TokenInfo.builder().message(e.getMessage()).build();
        }
    }

    @GetMapping(value = "/check")
    public String check(){
        return "check";
    }
}
