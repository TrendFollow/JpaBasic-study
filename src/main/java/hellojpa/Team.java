package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

//    양쪽에 편의 메서드를 생성하지 말고 한 쪽에만 생성
//    public void addMember(Member member){
//        member.setTeam(this);
//        members.add(member);
//    }

}
