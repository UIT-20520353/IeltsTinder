package uit.se122.ieltstinder.service.dto.response;

import uit.se122.ieltstinder.entity.enumeration.TestLevel;

public record UserProfileResponseDto(
        Long id,
        String first_name,
        String last_name,
        String email,
        String address,
        String gender,
        Integer age,
        String description,
        String avatar,
        String token,
        TestLevel level
) {
}
