package calc.annotation;

import org.springframework.stereotype.Component;

@Component("abc")
public class Calculator {
  public int add(int a, int b) {
    return a + b;
  }
}
