package uit.se122.ieltstinder.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uit.se122.ieltstinder.entity.Test;
import uit.se122.ieltstinder.service.dto.TestDetailDto;
import uit.se122.ieltstinder.service.dto.TestDto;

@Component
@RequiredArgsConstructor
public class TestMapper {

    private final QuestionMapper questionMapper;

    public TestDto toTestDto(Test test) {
        return new TestDto(
                "Test " + test.getId(),
                test.getId(),
                test.getName(),
                test.getLevel()
        );
    }

    public TestDetailDto toTestDetailDto(Test test) {
        return new TestDetailDto(
                test.getId(),
                test.getName(),
                test.getLevel(),
                test.getQuestions().stream().map(questionMapper::toQuestionDto).toList(),
                test.getImage(),
                test.getParagraph()
        );
    }

}
