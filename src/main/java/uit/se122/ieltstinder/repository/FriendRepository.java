package uit.se122.ieltstinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uit.se122.ieltstinder.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
}
