package uit.se122.ieltstinder.service.dto.request;

import lombok.Data;

@Data
public class SubmitTestRequest {
    private Long userId;
    private Long testId;
    private Double result;
    private Long time;
}
