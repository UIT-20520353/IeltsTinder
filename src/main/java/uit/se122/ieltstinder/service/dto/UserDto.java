package uit.se122.ieltstinder.service.dto;

public record UserDto(
        Long id,
        String name,
        String email,
        String password,
        String address,
        String gender,
        Integer age,
        Double overall,
        Double target,
        String description,
        String avatar
) {
}
