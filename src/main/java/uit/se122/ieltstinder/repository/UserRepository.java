package uit.se122.ieltstinder.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uit.se122.ieltstinder.entity.User;
import uit.se122.ieltstinder.service.dto.UserDto;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.id <> :userId AND u.role <> 'ADMIN' AND u.status <> 'BLOCKED' " +
            "AND NOT EXISTS (SELECT 1 FROM Request r WHERE (r.sender.id = :userId AND r.receiver.id = u.id) " +
            "OR (r.sender.id = u.id AND r.receiver.id = :userId))")
    Page<User> findUsersNotInvolvedInRequestWithUserId(Long userId, Pageable pageable);

}
