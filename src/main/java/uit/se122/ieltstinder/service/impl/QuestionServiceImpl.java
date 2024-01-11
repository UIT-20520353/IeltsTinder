package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import uit.se122.ieltstinder.entity.Answer;
import uit.se122.ieltstinder.entity.Question;
import uit.se122.ieltstinder.entity.Test;
import uit.se122.ieltstinder.entity.enumeration.PartType;
import uit.se122.ieltstinder.exception.BadRequestException;
import uit.se122.ieltstinder.repository.AnswerRepository;
import uit.se122.ieltstinder.repository.QuestionRepository;
import uit.se122.ieltstinder.repository.TestRepository;
import uit.se122.ieltstinder.service.QuestionService;
import uit.se122.ieltstinder.service.ResourceService;
import uit.se122.ieltstinder.service.dto.request.AnswerRequestDto;
import uit.se122.ieltstinder.service.dto.request.AnswerRequestUpdateDto;
import uit.se122.ieltstinder.service.dto.request.QuestionReadingRequestDto;
import uit.se122.ieltstinder.service.dto.request.QuestionRequestUpdateDto;
import uit.se122.ieltstinder.service.query.QueryService;

import java.util.List;
import java.util.Objects;

import static uit.se122.ieltstinder.constant.MessageConstant.*;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl  extends QueryService<Question> implements QuestionService {

    private final QuestionRepository questionRepository;
    private final TestRepository testRepository;
    private final ResourceService resourceService;
    private final AnswerRepository answerRepository;

    @Override
    @Transactional
    public void addQuestion(Long testId, String question, PartType type, MultipartFile resource, List<AnswerRequestDto> answers) {
//        Test test = testRepository
//                        .findById(testId)
//                        .orElseThrow(() -> new BadRequestException(TEST_NOT_EXIST));
//
//        String url = "";
//        if (type == PartType.LISTENING) {
//            url = resourceService.uploadAudio(resource);
//        }
//
//        Question newQuestion = questionRepository.save(Question
//                                    .builder()
//                                    .type(type)
//                                    .question(question)
//                                    .test(test)
//                                    .resource(url)
//                                    .build()
//                                );
//
//        answers.forEach(answer -> {
//            answerRepository.save(
//                    Answer.builder()
//                            .content(answer.getContent())
//                            .question(newQuestion)
//                            .isResult(answer.getIsResult() ? 1L : 0)
//                            .build()
//            );
//        });
    }

    @Override
    @Transactional
    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    @Override
    @Transactional
    public void updateQuestion(QuestionRequestUpdateDto question, List<AnswerRequestUpdateDto> answers, MultipartFile resource) {
//        String url = "";
//        if (Objects.nonNull(resource)) {
//            url = resourceService.uploadAudio(resource);
//        }
//
//        Question targetQuestion = questionRepository
//                .findById(question.getId())
//                .orElseThrow(() -> new BadRequestException(QUESTION_NOT_EXIST));
//
//        if (Strings.isNotBlank(url)) {
//            targetQuestion.setResource(url);
//        }
//        targetQuestion.setQuestion(question.getQuestion());
//
//        answers.forEach(answer -> {
//            if (answer.getId() != -1) {
//                Answer targetAnswer = answerRepository
//                                        .findById(answer.getId())
//                                        .orElseThrow(() -> new BadRequestException(ANSWER_NOT_EXIST));
//                targetAnswer.setContent(answer.getContent());
//                targetAnswer.setIsResult(answer.getIsResult() ? 1L : 0);
//                targetAnswer.setQuestion(targetQuestion);
//            }
//        });
    }

    @Override
    @Transactional
    public void addQuestionReading(QuestionReadingRequestDto request) {
//        Test test = testRepository
//                .findById(request.getTestId())
//                .orElseThrow(() -> new BadRequestException(TEST_NOT_EXIST));
//
//        Question question = questionRepository.save(Question
//                .builder()
//                .type(request.getType())
//                .question(request.getQuestion())
//                .test(test)
//                .resource("")
//                .build());
//
//        request.getAnswers().forEach(answer -> {
//            answerRepository.save(Answer
//                    .builder()
//                    .content(answer.getContent())
//                    .isResult(answer.getIsResult() ? 1L : 0)
//                    .question(question)
//                    .build());
//        });
    }

}
