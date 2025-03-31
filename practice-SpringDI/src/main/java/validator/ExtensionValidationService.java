package validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ExtensionValidationService {

  private final ExtensionValidator validator;

  @Autowired
  public ExtensionValidationService(@Qualifier("imageValidator") ExtensionValidator validator) {
    this.validator = validator;
  }

  public void validate(String filename) {
    boolean result = validator.isValid(filename);
    System.out.println("파일 \"" + filename + "\"  검사 결과 " + result);
  }
}
