package uit.se122.ieltstinder.service.dto;

import uit.se122.ieltstinder.entity.enumeration.TestLevel;

public record TestDto(
        String key,
        Long id,
        String name,
        TestLevel level
) {
}
