package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int quantity; // 주문 수량

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  //하나의 User가 여러 개의 Order를 가질 수 있다 = Order 입장에서 여러 주문이 한 사용자(User)에 속함

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
  private Payment payment;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", quantity=" + quantity +
        ", user=" + user +
        ", product=" + product +
        ", payment=" + payment +
        '}';
  }
}

