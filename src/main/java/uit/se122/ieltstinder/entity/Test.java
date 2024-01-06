package uit.se122.ieltstinder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import uit.se122.ieltstinder.entity.enumeration.TestLevel;

import java.util.List;

@Entity
@Table(name = "t_tests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private TestLevel level;

    @OneToMany(mappedBy = "test", fetch = FetchType.LAZY)
    private List<Question> questions;

    @Column(name = "image_reading")
    private String image;

    @Column(name = "paragraph")
    private String paragraph;

}
