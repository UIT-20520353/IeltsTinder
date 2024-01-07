package uit.se122.ieltstinder.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import uit.se122.ieltstinder.service.criteria.TestCriteria;
import uit.se122.ieltstinder.service.dto.TestDetailDto;
import uit.se122.ieltstinder.service.dto.TestDto;
import uit.se122.ieltstinder.service.dto.request.CreateTestDto;
import uit.se122.ieltstinder.service.dto.request.TestRequest;

import java.util.Optional;

public interface TestService {
    Page<TestDto> getAllTests(TestCriteria criteria, Pageable pageable);
    TestDetailDto getTest(Long testId);
    TestDto updateTest(Long testId, TestRequest request);
    void addReadingResource(Long testId, MultipartFile resource, String paragraph);
    void createTest(CreateTestDto request);
}
