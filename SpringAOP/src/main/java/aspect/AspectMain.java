package aspect;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectMain {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/calc-annotation.xml");
    BusinessProcess bp = (BusinessProcess) context.getBean("businessProcess");
    bp.bp();
    System.out.println("=====================================");

    bp.no_bp();
    System.out.println("=====================================");

    bp.int_bp();
    System.out.println("=====================================");

    bp.int_String_bp("s1", 0);
    System.out.println("=====================================");

    context.close();
  }
}
