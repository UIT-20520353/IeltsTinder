package uit.se122.ieltstinder.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "content")
    private String content;

    @Column(name = "videourl")
    private String videoUrl;

}
