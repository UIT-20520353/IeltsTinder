package uit.se122.ieltstinder.service.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uit.se122.ieltstinder.service.query.Criteria;
import uit.se122.ieltstinder.service.query.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCriteria implements Serializable, Criteria {

    private StringFilter name;

    public TestCriteria(TestCriteria other) {
        this.name = Objects.nonNull(other) ? other.name : null;
    }

    @Override
    public Criteria copy() {
        return new TestCriteria(this);
    }

}
