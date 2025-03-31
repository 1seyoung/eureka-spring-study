package annotation;
@SimpleUserInfo(name = "홍길동", age = 28, job = "백엔드 개발자")
public class User {
  private String name;
  private String password;

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public String toString() {
    return "User{name='" + name + "', password='" + password + "'}";
  }
}
