package uit.se122.ieltstinder.service.dto;

import uit.se122.ieltstinder.service.AnswerDto;

import java.util.List;

public record QuestionDetailDto(
        Long id,
        String text,
        String explain,
        List<AnswerDto> answers
) {
}
