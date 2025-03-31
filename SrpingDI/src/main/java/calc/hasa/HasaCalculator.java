package calc.hasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//Calculator 객체 필요
// CalcMain의 spring confiext를 통해서 HasaCalculator 객체 생성 (DI)
@Component
public class HasaCalculator {
  //Spring DI 를 사용하지 않는 경우 calculator
//  Calculator calculator = new Calculator();
//
//  public int add(int a, int b) {
//    System.out.println("HasaCalculator.add()");
//    return calculator.add(a, b);
//  }

  //Spring DI 를 사용하는 경우
//  @Autowired
//  Calculator calculator = new Calculator();


  //Spring DI #2 setter injection
//  Calculator calculator;

//  public void setCalculator(Calculator calculator) {
//    this.calculator = calculator;
//  }

  //Spring DI #3 constructor injection (spring 추천 방식)
  //@Autowired 필요 없음
  Calculator calculator; // lombook 사용하면 final 로 선언함

  @Autowired
  public HasaCalculator(Calculator calculator) {
    super();
    this.calculator = calculator;
  }

  public int add(int a, int b) {
    System.out.println("HasaCalculator.add()");
    return calculator.add(a, b);
  }
}
