package uit.se122.ieltstinder.service.dto;

public record UserDto(
        Long id,
        String firstName,
        String lastName,
        String address,
        String gender,
        Integer age,
        Double overall,
        Double target,
        String description,
        String avatar
) {
}
