package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int id;

  private String name;

  // cascade 설정 전 (기본설정은 아무것도 안한다.)
  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name="passport") // person table 의 어느 컬럼인지 명시
  private Passport passport;

  // cascade 설정 (연관관계의 객체도 함께 persist )
//  @OneToOne(cascade=CascadeType.PERSIST)
//  @JoinColumn(name="passport") // person table 의 어느 컬럼인지 명시
//  private Passport passport;

  // fetch 설정 (연관관계의 객체를 즉시가 아닌 사용하는 시점에 가져온다. )
//  @OneToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
//  @JoinColumn(name="passport") // person table 의 어느 컬럼인지 명시
//  private Passport passport;

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Passport getPassport() {
    return passport;
  }
  public void setPassport(Passport passport) {
    this.passport = passport;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", name=" + name + ", passport=" + passport + "]";
  }
}