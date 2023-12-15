package uit.se122.ieltstinder.service.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uit.se122.ieltstinder.entity.enumeration.Role;
import uit.se122.ieltstinder.service.query.Criteria;
import uit.se122.ieltstinder.service.query.filter.Filter;
import uit.se122.ieltstinder.service.query.filter.LongFilter;
import uit.se122.ieltstinder.service.query.filter.StringFilter;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCriteria implements Serializable, Criteria {

    private StringFilter name;
    private UserRoleFilter role;

    public UserCriteria(UserCriteria other) {
        this.name = Objects.nonNull(other.name) ? other.name : null;
        this.role = Objects.nonNull(other.role) ? other.role : null;
    }

    @Override
    public Criteria copy() {
        return new UserCriteria(this);
    }

    public static class UserRoleFilter extends Filter<Role> implements Serializable {
        private static final long serialVersionUID = 1L;

        public UserRoleFilter() {
        }

        public UserRoleFilter(UserRoleFilter other) {
            super(other);
        }

        @Override
        public Filter<Role> copy() {
            return new UserRoleFilter(this);
        }
    }

}
