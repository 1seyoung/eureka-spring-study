package configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CalcMain {

  public static void main(String[] args) {
    // 개발자가 직접 객체 생성
//		Calculator calculator = new Calculator(); // 생성된 객체 의존성
//		System.out.println(c alculator.add(3, 7));

    // Spring DI 를 통한 객체 생성
    // main() 에서 Spring Framework 의 환경
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class); // 설정 java Configurations [ annotation 기반 ]
    Calculator calculator = (Calculator)context.getBean("calculator"); // id 기준 객체를 DI -> 여기도 2
    System.out.println(calculator.add(3, 7));
    context.close();
  }

}