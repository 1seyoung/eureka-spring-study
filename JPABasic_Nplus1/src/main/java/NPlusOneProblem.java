import config.MyPersistenceUnitInfo;
import entity.School;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.jpa.HibernatePersistenceProvider;

public class NPlusOneProblem {

  public static void main(String[] args) {
    Map<String, String> props = new HashMap<>();
    props.put("hibernate.show_sql", "true");

    EntityManagerFactory emf = new HibernatePersistenceProvider()
        .createContainerEntityManagerFactory(new MyPersistenceUnitInfo(), props);
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    System.out.println("====== N + 1 발생 예제 ======");

    // 학교 목록만 조회
    String jpql = "SELECT s FROM School s";
    List<School> schools = em.createQuery(jpql, School.class).getResultList();

    // 연관된 학생 리스트 접근 → 학생 수만 확인하지만 쿼리 N번 발생 (학교 수만큼)
    for (School school : schools) {
      System.out.println("학교 이름: " + school.getName() +
          ", 재학생 수: " + school.getStudents().size()); // N + 1 발생
    }

    em.getTransaction().commit();
    em.close();
  }
}