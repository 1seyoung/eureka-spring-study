import config.MyPersistenceUnitInfo;
import entity.School;
import entity.Student;
import entity.Subject;
import entity.SubjectRegistration;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.jpa.HibernatePersistenceProvider;

public class Test {
  public static void main(String[] args) {
    Map<String, String> props = new HashMap<>();
    props.put("hibernate.show_sql", "true");
    props.put("hibernate.hbm2ddl.auto", "create");

    EntityManagerFactory emf = new HibernatePersistenceProvider()
        .createContainerEntityManagerFactory(new MyPersistenceUnitInfo(), props);
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();

    // ---------- 데이터 삽입 시작 ----------

    School school1 = new School("하늘고등학교");
    School school2 = new School("바다중학교");

    Student student1 = new Student("김철수", school1);
    Student student2 = new Student("이영희", school1);
    Student student3 = new Student("박민수", school2);

    Subject math = new Subject("수학");
    Subject english = new Subject("영어");
    Subject science = new Subject("과학");

    // 학생 수강 등록
    SubjectRegistration reg1 = new SubjectRegistration(student1, math);
    SubjectRegistration reg2 = new SubjectRegistration(student1, english);
    SubjectRegistration reg3 = new SubjectRegistration(student2, science);
    SubjectRegistration reg4 = new SubjectRegistration(student3, math);

    // 저장
    em.persist(school1);
    em.persist(school2);

    em.persist(student1);
    em.persist(student2);
    em.persist(student3);

    em.persist(math);
    em.persist(english);
    em.persist(science);

    em.persist(reg1);
    em.persist(reg2);
    em.persist(reg3);
    em.persist(reg4);

    // ---------- 데이터 삽입 끝 ----------

    em.getTransaction().commit();
    em.close();
  }
}
