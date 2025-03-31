package calc.hasa;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
  public int add(int a, int b) {
    return a + b;
  }
}
