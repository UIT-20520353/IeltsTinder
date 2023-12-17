package uit.se122.ieltstinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uit.se122.ieltstinder.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
