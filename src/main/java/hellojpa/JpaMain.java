package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {
            Member member1 = new Member();
            Member member2 = new Member();
            member1.setName("helloA");
            member2.setName("helloB");
            em.persist(member1);
            em.persist(member2);

            List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();

            for(Member member : result){
                System.out.println(member.toString());
            }
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
