package hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
public class Member extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    // 지연로딩(LAZY) = 프록시로 가져오게 된다. 팀을 호출하는 순간 프록시 초기화되서 select team이 나간다.
    // 즉시로딩(EAGER) = member를 조회하는 순간 팀도 같이 조인해서 가져온다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    @Embedded
    private Period workPeriod;

    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "Favorite_food", joinColumns = @JoinColumn(name = "member_id"))
    @Column(name = "Food_name")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "Address", joinColumns = @JoinColumn(name = "member_id"))
    private List<Address> addressHistory = new ArrayList<>();

    // 양쪽에 편의 메서드를 생성하지 말고 한 쪽에만 생성
    public void setTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }

//    외래키로 참조, 연관관계 매핑 x
//    @Column(name = "team_id")
//    private Long teamId;

}
