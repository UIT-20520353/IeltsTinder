package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import uit.se122.ieltstinder.entity.Test;
import uit.se122.ieltstinder.entity.Test_;
import uit.se122.ieltstinder.repository.TestRepository;
import uit.se122.ieltstinder.service.TestService;
import uit.se122.ieltstinder.service.criteria.TestCriteria;
import uit.se122.ieltstinder.service.dto.TestDto;
import uit.se122.ieltstinder.service.mapper.TestMapper;
import uit.se122.ieltstinder.service.query.QueryService;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TestServiceImpl extends QueryService<Test> implements TestService {

    private final TestRepository testRepository;
    private final TestMapper testMapper;

    @Override
    public Page<TestDto> getAllTests(TestCriteria criteria, Pageable pageable) {
        Specification<Test> specification = createSpecification(criteria);
        return testRepository.findAll(specification, pageable).map(testMapper::toTestDto);
    }

    private Specification<Test> createSpecification(TestCriteria criteria) {
        Specification<Test> specification = Specification.where(null);

        if (criteria != null) {
            if (Objects.nonNull(criteria.getName())) {
                specification = specification.and(buildSpecification(criteria.getName(),
                        root -> root.get(Test_.name)));
            }
        }

        return  specification;
    }
}
