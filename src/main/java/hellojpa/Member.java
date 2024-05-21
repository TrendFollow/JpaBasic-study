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

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

    // 양쪽에 편의 메서드를 생성하지 말고 한 쪽에만 생성
    public void setTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }

//    외래키로 참조, 연관관계 매핑 x
//    @Column(name = "team_id")
//    private Long teamId;

}
