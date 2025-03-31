package validator;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExtensionMain {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("xml/extension-annotation.xml");

    ExtensionValidationService service = context.getBean(ExtensionValidationService.class);
    service.validate("profile.png");     // 이미지 검사기라면 true
    service.validate("report.pdf");      // 이미지 검사기라면 false

    context.close();
  }
}