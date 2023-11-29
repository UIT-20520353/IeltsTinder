package uit.se122.ieltstinder.service.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uit.se122.ieltstinder.service.query.Criteria;
import uit.se122.ieltstinder.service.query.filter.LongFilter;
import uit.se122.ieltstinder.service.query.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCriteria implements Serializable, Criteria {

    private StringFilter firstName;

    public UserCriteria(UserCriteria other) {
        this.firstName = Objects.nonNull(other.firstName) ? other.firstName : null;
    }

    @Override
    public Criteria copy() {
        return new UserCriteria(this);
    }

}
