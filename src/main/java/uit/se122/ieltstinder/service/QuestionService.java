package uit.se122.ieltstinder.service;

import org.springframework.web.multipart.MultipartFile;
import uit.se122.ieltstinder.entity.enumeration.PartType;
import uit.se122.ieltstinder.service.dto.request.*;

import java.util.List;

public interface QuestionService {
    void deleteQuestion(Long questionId);
    void updateQuestion(QuestionRequestUpdateDto question, List<AnswerRequestUpdateDto> answers, MultipartFile resource);
    void createQuestion(CreateQuestionDto request);
}
