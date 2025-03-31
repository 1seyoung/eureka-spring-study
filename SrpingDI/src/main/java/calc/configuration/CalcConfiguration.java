package calc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//xml annotation 대체
@Configuration
public class CalcConfiguration {
  // 메소드로 DI 표현
  @Bean
  public Calculator calculator() { //method 이름이 DI -> 2 붙으면 (main line 16)
    return new Calculator();
  }
}
