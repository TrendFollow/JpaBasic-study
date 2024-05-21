package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public void setTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }

//    외래키로 참조, 연관관계 매핑 x
//    @Column(name = "team_id")
//    private Long teamId;

}
