package hellojpa;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR",
                    sequenceName = "MEMBER_SEQ",
                    initialValue = 1, allocationSize = 50)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
                    generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    private LocalDate testLocalDate;

    private LocalDateTime testLocalDateTime;

    @Lob
    private String description;

}
