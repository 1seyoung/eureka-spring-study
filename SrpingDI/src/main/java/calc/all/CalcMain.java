package calc.all;

import calc.hasa.HasaCalculator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

  public static void main(String[] args) {
    // 개발자가 직접 객체 생성
//		Calculator calculator = new Calculator(); // 생성된 객체 의존성
//		System.out.println(calculator.add(3, 7));

    // Spring DI 를 통한 객체 생성
    // main() 에서 Spring Framework 의 환경
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/all-calc-annotation.xml"); // 설정 xml 문서
    calc.hasa.HasaCalculator hasaCalculator = (HasaCalculator)context.getBean("hasaCalculator"); // id 기준 객체를 DI
    System.out.println(hasaCalculator.add(3, 7));
    context.close();
  }

}