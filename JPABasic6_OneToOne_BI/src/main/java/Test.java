import config.MyPersistenceUnitInfo;
import entity.Passport;
import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.jpa.HibernatePersistenceProvider;

// @OneToOne 연관관계를 통해 Person 테미블에 FK 로 Passport 가 설정된다.
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

    Person person = new Person();
    person.setName("홍길동");

    Passport passport = new Passport();
    passport.setNumber("KOR124");

    // #1. 객체 연결없이 각각 따로 persist 하면 오류 없이 insert 된다.
    em.persist(person);
    // Hibernate: insert into Person (name,passport) values (?,?)
    // passport 는 null

//		em.persist(passport);
    // Hibernate: insert into Passport (number) values (?)

    // #2. 객체 연결, person 만 persist
//		person.setPassport(passport);

//		em.persist(person);
    // org.hibernate.TransientObjectException: persistent instance references an unsaved transient instance of 'entity.Passport' (save the transient instance before flushing)
    // passport 영속화 되지 않은 상태 => 오류 발생

//		em.persist(passport);
    // Hibernate: insert into Passport (number) values (?)
    // 정상적으로 insert


    // 3. 객체 연결, person -> passport persist
//		person.setPassport(passport);
//		
//		em.persist(person);
//		em.persist(passport);

//		Hibernate: insert into Person (name,passport) values (?,?)
//		Hibernate: insert into Passport (number) values (?)
//		Hibernate: update Person set name=?,passport=? where id=?
//		Person 이 먼저 insert 되는 과정에서 Passport 의 id 값을 모르므로
//		Passport 가 insert 되는 과정에서 획득한 AI key 값을 이용해서 다시 한번 update 수행		
//		insert 과정에서 AI key 를 반환하도록 수행 (jpa)		


    // 4. 객체 연결, passport -> person persist
//		person.setPassport(passport);
//		
//		em.persist(passport);	
//		em.persist(person);

//		Hibernate: insert into Passport (number) values (?)
//		Hibernate: insert into Person (name,passport) values (?,?)

    // 5. 객체 연결, Person 의 @OneToOne(cascade=CascadeType.PERSIST) 추가
    person.setPassport(passport);

//		em.persist(passport);	
    em.persist(person);

//		Hibernate: insert into Passport (number) values (?)
//		Hibernate: insert into Person (name,passport) values (?,?)		
    em.getTransaction().commit();  // 이 시점에 테이블에 반영한다.

    em.close();
  }

}