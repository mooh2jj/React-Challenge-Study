package auth.authserver.member;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    @NotBlank(message = "email must not be Blank")
    private String email;

    @NotBlank(message = "password must not be Blank")
    private String password;

    @NotBlank(message = "name must not be Blank")
    private String name;

    @NotBlank(message = "role must not be Blank")
    private String role;
}
