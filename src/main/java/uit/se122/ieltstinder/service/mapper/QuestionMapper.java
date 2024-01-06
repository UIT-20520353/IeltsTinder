package uit.se122.ieltstinder.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uit.se122.ieltstinder.entity.Question;
import uit.se122.ieltstinder.service.dto.QuestionDto;

@Component
@RequiredArgsConstructor
public class QuestionMapper {

    private final AnswerMapper answerMapper;

    public QuestionDto toQuestionDto(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getType(),
                question.getQuestion(),
                question.getResource(),
                question.getAnswers().stream().map(answerMapper::toAnswerDto).toList()
        );
    }

}
