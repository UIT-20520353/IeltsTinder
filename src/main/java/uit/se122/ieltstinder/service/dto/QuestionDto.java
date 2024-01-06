package uit.se122.ieltstinder.service.dto;

import uit.se122.ieltstinder.entity.enumeration.PartType;
import uit.se122.ieltstinder.service.AnswerDto;

import java.util.List;

public record QuestionDto(
        Long id,
        PartType type,
        String question,
        String resource,
        List<AnswerDto> answers
) {
}
