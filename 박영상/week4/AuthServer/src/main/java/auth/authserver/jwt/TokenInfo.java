package auth.authserver.jwt;

import lombok.Builder;

@Builder
public record TokenInfo(String grantType, String accessToken, String refreshToken, String message) {
}
