package uit.se122.ieltstinder.service.dto.response;

public record AuthLoginResponseDto(
        String accessToken,
        String refreshToken
) {
}
