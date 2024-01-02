package uit.se122.ieltstinder.service.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uit.se122.ieltstinder.entity.Test;
import uit.se122.ieltstinder.service.dto.TestDto;

@Component
@RequiredArgsConstructor
public class TestMapper {

    public TestDto toTestDto(Test test) {
        return new TestDto(
                test.getId(),
                test.getName(),
                test.getLevel()
        );
    }

}
