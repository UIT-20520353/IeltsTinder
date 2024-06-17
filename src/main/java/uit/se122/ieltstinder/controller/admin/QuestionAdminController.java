package uit.se122.ieltstinder.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uit.se122.ieltstinder.entity.enumeration.PartType;
import uit.se122.ieltstinder.service.QuestionService;
import uit.se122.ieltstinder.service.dto.request.*;

import java.util.List;

@RequestMapping(value = "/api/admin/questions")
@RestController
@RequiredArgsConstructor
@Tag(name = "Admin Questions Resource")
public class QuestionAdminController {

    private final QuestionService questionService;

    @DeleteMapping(value = "{questionId}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long questionId) {
        questionService.deleteQuestion(questionId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/update", consumes = { "multipart/form-data" })
    public ResponseEntity<Void> updateQuestion(@RequestPart(name = "resource", required = false) MultipartFile resource,
                                               @Valid @RequestPart("question") QuestionRequestUpdateDto question,
                                               @Valid @RequestPart("answers") List<AnswerRequestUpdateDto> answers) {
        questionService.updateQuestion(question, answers, resource);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(consumes = { "multipart/form-data" })
    public ResponseEntity<Void> createQuestion(@Valid @ModelAttribute CreateQuestionDto request) {
        questionService.createQuestion(request);
        return ResponseEntity.noContent().build();
    }

}
