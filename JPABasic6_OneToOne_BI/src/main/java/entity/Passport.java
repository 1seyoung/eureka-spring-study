package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// Person <-> Passport (양방향)
@Entity
public class Passport {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;

  private String number;

  @OneToOne(mappedBy="passport") // Owenership 을 가진 Entity인 Person 에서 설정한 passport 와 연계
  private Person person;

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getNumber() {
    return number;
  }
  public void setNumber(String number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return "Passport [id=" + id + ", number=" + number + "]";
  }
}