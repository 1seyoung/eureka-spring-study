package calc.all;

import calc.hasa.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//Calculator 객체 필요
// CalcMain의 spring confiext를 통해서 HasaCalculator 객체 생성 (DI)
@Component
public class HasaCalculator {

  //Spring DI #3 constructor injection (spring 추천 방식)
  //@Autowired 필요 없음
  @Autowired
  @Qualifier("bbb")
  Calculator calculator; // lombook 사용하면 final 로 선언함

  @Autowired
  public HasaCalculator(@Qualifier("aaa") Calculator calculator) {
    super();
    this.calculator = calculator;
  }

  public int add(int a, int b) {
    System.out.println("HasaCalculator.add()");
    return calculator.add(a, b);
  }
}
