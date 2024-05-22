package hellojpa;

import hellojpa.domain.Child;
import hellojpa.domain.Member;
import hellojpa.domain.Parent;
import hellojpa.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        tx.begin();
//        em.createNativeQuery("DROP TABLE IF EXISTS Movie").executeUpdate();
//        em.createNativeQuery("DROP TABLE IF EXISTS Book").executeUpdate();
//        em.createNativeQuery("DROP TABLE IF EXISTS Album").executeUpdate();
//        em.createNativeQuery("DROP TABLE IF EXISTS Item").executeUpdate();
//        em.createNativeQuery("DROP TABLE IF EXISTS MEMBER ").executeUpdate();
//        em.createNativeQuery("DROP TABLE IF EXISTS TEAM ").executeUpdate();

        try {
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
//            cascade.ALL 사용시 나머지도 자동 persist 해준다.
//            em.persist(child1);
//            em.persist(child2);

//            지연로딩, 즉시로딩, 프록시
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//
//            em.flush();
//            em.clear();
//
//            Member m = em.find(Member.class, member.getId());
//            System.out.println(m.getTeam().getClass());
//
//            System.out.println("============================");
//            System.out.println(m.getTeam().getName());
//            System.out.println("============================");

            
            // getReference 먼저 호출하면 member1, reference 둘 다 프록시 객체
            // find 먼저 호출하면 member1, reference 둘 다 Member 객체
//            Member member1 = em.find(Member.class, 4L);
//            Member reference = em.getReference(Member.class, 4L);
//            System.out.println(reference.getClass());
//
//            System.out.println(member1.getClass());
//            System.out.println(reference == member1);


//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbb");
//            movie.setName("바람과 함께 사라지다.");
//            movie.setPrice(10000);
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findMovie = em.find(Movie.class, movie.getId());
//            System.out.println("findMovie = " + findMovie);


//             양방향 연관관계, 순수 객체 상태를 고려해서 항상 양쪽에 값을 설정해야 한다.
//             연관관계 편의 메서드를 생성하자!!!!!
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//
////            em.flush();
////            em.clear();
//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();
//            for (Member m : members) {
//                System.out.println(m.getUsername());
//            }
//
//             단방향 연관관계
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Team team1 = new Team();
//            team.setName("TeamB");
//            em.persist(team1);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = findMember.getTeam();
//            System.out.println(findTeam.toString());
//
//            Team team2 = em.find(Team.class, team1.getId());
//            team2.setName("Team2");
//
//            외래키로 각각 select, 연관관계 매핑 x
//            Team team = new Team();
//            team.setName("TeamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            Member findMember = em.find(Member.class, member.getId());
//            Long teamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, teamId);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("username : " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username : " + username);

        Team team = member.getTeam();
        System.out.println("team : " + team.getName());
    }
}
