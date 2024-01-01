package uit.se122.ieltstinder.service.dto;

import uit.se122.ieltstinder.entity.enumeration.Role;
import uit.se122.ieltstinder.entity.enumeration.UserStatus;

public record UserAdminDto(
        String key,
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
        String avatar,
        UserStatus status,
        Role role
) {
}
