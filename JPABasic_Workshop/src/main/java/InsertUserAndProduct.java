import config.MyPersistenceUnitInfo;
import entity.Product;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.jpa.HibernatePersistenceProvider;

public class InsertUserAndProduct {

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


    User user = new User();
    user.setName("홍길동");

    Product product = new Product();
    product.setName("로지텍 기계식 키보드");
    product.setPrice(95000);

    em.persist(user);
    em.persist(product);


    // ----------

    em.getTransaction().commit();
    em.close();
  }

}
