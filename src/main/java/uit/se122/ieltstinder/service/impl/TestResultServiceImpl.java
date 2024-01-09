package uit.se122.ieltstinder.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uit.se122.ieltstinder.entity.Test;
import uit.se122.ieltstinder.entity.TestResult;
import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.exception.BadRequestException;
import uit.se122.ieltstinder.repository.TestRepository;
import uit.se122.ieltstinder.repository.TestResultRepository;
import uit.se122.ieltstinder.repository.UserRepository;
import uit.se122.ieltstinder.service.TestResultService;
import uit.se122.ieltstinder.service.dto.request.SubmitTestRequest;
import uit.se122.ieltstinder.service.query.QueryService;

import static uit.se122.ieltstinder.constant.MessageConstant.TEST_NOT_EXIST;
import static uit.se122.ieltstinder.constant.MessageConstant.USER_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class TestResultServiceImpl extends QueryService<TestResult> implements TestResultService {

    private final TestResultRepository testResultRepository;
    private final UserRepository userRepository;
    private final TestRepository testRepository;

    @Override
    @Transactional
    public void submitResult(SubmitTestRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new BadRequestException(USER_NOT_EXIST));

        Test test = testRepository.findById(request.getTestId())
                        .orElseThrow(() -> new BadRequestException(TEST_NOT_EXIST));

        testResultRepository.save(TestResult.builder()
                .user(user)
                .test(test)
                .result(request.getResult())
                .time(request.getTime())
                .build());
    }
}
