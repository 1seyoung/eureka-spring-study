import config.MyPersistenceUnitInfo;
import entity.Comment;
import entity.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.jpa.HibernatePersistenceProvider;


public class Test {

  public static void main(String[] args) {

    Map<String, String> props = new HashMap<>();
    props.put("hibernate.show_sql", "true");
    props.put("hibernate.hbm2ddl.auto", "create"); // create : drop & create,  update : 있으면 안 건드리고 없으면 만든다.


    EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
        new MyPersistenceUnitInfo(), props
    );
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    // ----------

    Post p = new Post();
    p.setTitle("제목1");
    p.setContent("내용1");

    em.persist(p);

    Comment c1 = new Comment();
    c1.setContent("댓글1");
    c1.setPost(p);

    Comment c2 = new Comment();
    c2.setContent("댓글2");

    //1. post 만
    //c1.setPost(p);

    // 2. comment 만
    em.persist(c1);


    //------------


    em.getTransaction().commit();  // 이 시점에 테이블에 반영한다.

    em.close();
  }

}