package uit.se122.ieltstinder.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uit.se122.ieltstinder.entity.Request;

import java.util.Optional;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>, JpaSpecificationExecutor<Request> {

    @Query("SELECT r FROM Request r WHERE r.user.id = :fk_user_id")
    Page<Request> findByUserId(Long fk_user_id, Pageable pageable);

}
