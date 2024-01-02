package uit.se122.ieltstinder.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uit.se122.ieltstinder.service.criteria.TestCriteria;
import uit.se122.ieltstinder.service.dto.TestDto;

public interface TestService {
    Page<TestDto> getAllTests(TestCriteria criteria, Pageable pageable);
}
