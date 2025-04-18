import config.MyPersistenceUnitInfo;
import entity.Order;
import entity.Payment;
import entity.Product;
import entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.hibernate.jpa.HibernatePersistenceProvider;

public class Main {
  private static EntityManagerFactory emf;
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    initEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    while (true) {
      printMenu();
      String input = scanner.nextLine();

      switch (input) {
        case "1" -> registerUser(em);
        case "2" -> registerProduct(em);
        case "3" -> createOrder(em);
        case "4" -> listOrders(em);
        case "0" -> {
          em.close();
          emf.close();
          System.out.println("시스템을 종료합니다.");
          return;
        }
        default -> System.out.println("올바른 번호를 입력하세요.");
      }
    }
  }

  private static void printMenu() {
    System.out.println("\n=== 주문 시스템 ===");
    System.out.println("1. 사용자 등록");
    System.out.println("2. 상품 등록");
    System.out.println("3. 주문 생성");
    System.out.println("4. 주문 전체 조회");
    System.out.println("0. 종료");
    System.out.print("선택: ");
  }

  private static void registerUser(EntityManager em) {
    System.out.print("사용자 이름 입력: ");
    String name = scanner.nextLine();

    em.getTransaction().begin();
    User user = new User();
    user.setName(name);
    em.persist(user);
    em.getTransaction().commit();

    System.out.println("사용자 등록 완료 (ID: " + user.getId() + ")");
  }

  private static void registerProduct(EntityManager em) {
    System.out.print("상품 이름 입력: ");
    String name = scanner.nextLine();
    System.out.print("상품 가격 입력: ");
    int price = Integer.parseInt(scanner.nextLine());

    em.getTransaction().begin();
    Product product = new Product();
    product.setName(name);
    product.setPrice(price);
    em.persist(product);
    em.getTransaction().commit();

    System.out.println("상품 등록 완료 (ID: " + product.getId() + ")");
  }

  private static void createOrder(EntityManager em) {
    System.out.print("사용자 ID 입력: ");
    int userId = Integer.parseInt(scanner.nextLine());
    System.out.print("상품 ID 입력: ");
    int productId = Integer.parseInt(scanner.nextLine());
    System.out.print("수량 입력: ");
    int quantity = Integer.parseInt(scanner.nextLine());
    System.out.print("결제 수단 입력 (예: 카드, 계좌): ");
    String method = scanner.nextLine();

    em.getTransaction().begin();

    User user = em.find(User.class, userId);
    Product product = em.find(Product.class, productId);

    if (user == null || product == null) {
      System.out.println("사용자 또는 상품을 찾을 수 없습니다.");
      em.getTransaction().rollback();
      return;
    }

    Order order = new Order();
    order.setUser(user);
    order.setProduct(product);
    order.setQuantity(quantity);

    Payment payment = new Payment();
    payment.setMethod(method);
    payment.setSuccess(true); // 기본 성공 처리

    order.setPayment(payment);
    em.persist(order);

    em.getTransaction().commit();

    System.out.println("주문 완료 (주문 ID: " + order.getId() + ")");
  }

  private static void listOrders(EntityManager em) {
    List<Order> orders = em.createQuery("SELECT o FROM Order o", Order.class).getResultList();
    System.out.println("=== 전체 주문 목록 ===");

    for (Order o : orders) {
      System.out.println("[주문 ID: " + o.getId() + "] " +
          o.getUser().getName() + "님이 " +
          o.getProduct().getName() + "을(를) " +
          o.getQuantity() + "개 주문함 / 결제: " +
          o.getPayment().getMethod() + " (" + (o.getPayment().isSuccess() ? "성공" : "실패") + ")");
    }
  }

  private static void initEntityManagerFactory() {
    Map<String, String> props = new HashMap<>();
    props.put("hibernate.show_sql", "true");
    props.put("hibernate.format_sql", "true");
    props.put("hibernate.hbm2ddl.auto", "update");

    emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
        new MyPersistenceUnitInfo(), props
    );
  }
}
