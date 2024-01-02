package uit.se122.ieltstinder.entity;

import jakarta.persistence.*;
import lombok.*;
import uit.se122.ieltstinder.entity.enumeration.TestLevel;

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

}
