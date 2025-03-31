package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Logging 을 담당하는 Aspect 클래스
@Component // 객체가 필요한 시점에 Spring 이 DI
@Aspect // aspectj 라이브러리에 의헤 AOP로 동작 <aop:aspectj-autoproxy />
public class LogAspect {

  //로깅을 위한 객체 생성
  // trace > debug > info > warn > error 메소드들은 얼마나 더 자세한 혹은 얼마나 더 중요한 로그를 남기느냐 따라 선택
  //Spring Boot의 현재 설정에 따라 로그 출력 결정 default : info
  // application.properties 에서 logging.level.root=debug 로 설정하면 debug 레벨 이상의 로그가 출력
  private final Logger logger = LoggerFactory.getLogger(this.getClass()); //LogBack 구현체(springboot default 구현체) -> 로그 남기는 녀석

  // PointCut ( Join Point 중 어떤 메소드에 끼어들 것인가 표현 )
  // @Pointcut(value="execution(* aspect.*.*(..))") // 모든 메소드
  // @Pointcut(value="execution(int aspect.*.*(..))") // int return join point
  // @Pointcut(value="execution(* aspect.*.*(String, int))") // String, int parameter join point
  //@Pointcut(value="execution(* aspect.*.*(..))")
  @Pointcut(value="execution(* aspect.sub.*.*(..))") // aspect 패키지 및 하위 패키지의 모든 메소드
  private void logPointcut() {} // 이름이 logPointcut 인 Pointcut 1개 생성

  // Advice 와 Join Point 에 의해 실제 로그 구현
  @Before("logPointcut()")
  public void beforeLog(JoinPoint joinPoint) {
    //Join Point 실제로 호출되는 메소드
    //System.out.println("[beforeLog] : " + joinPoint.getSignature().getName());

    logger.info("Logger : before");
    logger.info(joinPoint.getSignature().getName());
  }

  @After("logPointcut()")
  public void afterLog(JoinPoint joinPoint) {
    //Join Point 실제로 호출되는 메소드
    logger.debug("Logger : after");
    logger.info(joinPoint.getSignature().getName());
  }
}


//slf4j 라이브러리를 이용한 로깅 -> aspect ?? 뭐 과정?