package uit.se122.ieltstinder.service.dto;

import uit.se122.ieltstinder.entity.enumeration.TestLevel;

import java.util.List;

public record TestDetailDto (
        Long id,
        String name,
        TestLevel level,
        List<QuestionDto> questions,
        String image,
        String paragraph
) {
}
