package uit.se122.ieltstinder.service;

import org.springframework.web.multipart.MultipartFile;
import uit.se122.ieltstinder.entity.enumeration.PartType;
import uit.se122.ieltstinder.service.dto.request.AnswerRequestDto;
import uit.se122.ieltstinder.service.dto.request.AnswerRequestUpdateDto;
import uit.se122.ieltstinder.service.dto.request.QuestionReadingRequestDto;
import uit.se122.ieltstinder.service.dto.request.QuestionRequestUpdateDto;

import java.util.List;

public interface QuestionService {
    void addQuestion(Long testId, String question, PartType type, MultipartFile resource, List<AnswerRequestDto> answers);
    void deleteQuestion(Long questionId);
    void updateQuestion(QuestionRequestUpdateDto question, List<AnswerRequestUpdateDto> answers, MultipartFile resource);
    void addQuestionReading(QuestionReadingRequestDto request);
}
