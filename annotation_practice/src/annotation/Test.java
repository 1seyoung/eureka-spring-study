package annotation;

public class Test {

  public static void main(String[] args) throws ClassNotFoundException {
    Class<?> cls = Class.forName("annotation.User");

    if(cls.isAnnotationPresent(SimpleUserInfo.class)) {
      SimpleUserInfo simpleUserInfo = cls.getAnnotation(SimpleUserInfo.class);
      System.out.println("name: " + simpleUserInfo.name());
      System.out.println("age: " + simpleUserInfo.age());
      System.out.println("job: " + simpleUserInfo.job());
    } else {
      System.out.println("SimpleUserInfo annotation is not present.");
    }
  }
}
