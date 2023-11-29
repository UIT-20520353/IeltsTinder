package uit.se122.ieltstinder.service.dto.response;

public record UserProfileResponseDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        String address,
        String gender,
        Integer age,
        Double overall,
        Double target,
        String description,
        String avatar
) {
}
