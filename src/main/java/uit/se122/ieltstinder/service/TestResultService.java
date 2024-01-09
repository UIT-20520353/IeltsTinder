package uit.se122.ieltstinder.service;

import uit.se122.ieltstinder.service.dto.request.SubmitTestRequest;

public interface TestResultService {
    void submitResult(SubmitTestRequest request);
}
