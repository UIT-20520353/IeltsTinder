package uit.se122.ieltstinder.service.dto;

import uit.se122.ieltstinder.entity.User;

public record PostDto(
        Long id,
        UserDto user,
        String content,
        String videoUrl
) {
}
