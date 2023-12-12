package uit.se122.ieltstinder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Request extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_from_user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_to_user_id", nullable = false, referencedColumnName = "id")
    private User targetUser;

    public Request(User user, User targetUser) {
        this.user = user;
        this.targetUser = targetUser;
    }

}
