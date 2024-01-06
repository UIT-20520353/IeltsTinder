package uit.se122.ieltstinder.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uit.se122.ieltstinder.entity.Answer;
import uit.se122.ieltstinder.service.AnswerDto;

@Component
@RequiredArgsConstructor
public class AnswerMapper {

    public AnswerDto toAnswerDto(Answer answer) {
        return new AnswerDto(
                answer.getId(),
                answer.getContent(),
                answer.getIsResult() == 1
        );
    }

}
