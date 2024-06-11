package uit.se122.ieltstinder.service.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import static uit.se122.ieltstinder.constant.MessageConstant.TEST_ID_REQUIRED_ERROR;

@Data
public class CreateQuestionDto {

    @NotNull(message = TEST_ID_REQUIRED_ERROR)
    private Long testId;

}
