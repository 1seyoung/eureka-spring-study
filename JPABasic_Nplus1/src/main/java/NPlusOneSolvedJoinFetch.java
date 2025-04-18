import config.MyPersistenceUnitInfo;
import entity.School;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.jpa.HibernatePersistenceProvider;

public class NPlusOneSolvedJoinFetch {
  public static void main(String[] args) {
    Map<String, String> props = new HashMap<>();
    props.put("hibernate.show_sql", "true");

    EntityManagerFactory emf = new HibernatePersistenceProvider()
        .createContainerEntityManagerFactory(new MyPersistenceUnitInfo(), props);
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    System.out.println("====== join fetch로 해결 ======");

    String jpql = "SELECT s FROM School s JOIN FETCH s.students";
    List<School> schools = em.createQuery(jpql, School.class).getResultList();

    for (School school : schools) {
      System.out.println("학교 이름: " + school.getName() +
          ", 재학생 수: " + school.getStudents().size());
    }

    em.getTransaction().commit();
    em.close();
  }
}