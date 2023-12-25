package uit.se122.ieltstinder.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uit.se122.ieltstinder.entity.Request;

import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>, JpaSpecificationExecutor<Request> {

    @Query("SELECT r FROM Request r WHERE r.sender.id = :fk_user_id")
    Page<Request> findByUserId(Long fk_user_id, Pageable pageable);

    @Modifying
    @Transactional
    @Query("DELETE FROM Request  r WHERE r.sender.id = :sender AND r.receiver.id = :receiver")
    Integer deleteBySenderAndReceiver(Long sender, Long receiver);

}
