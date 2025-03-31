package validator;

import org.springframework.stereotype.Component;

@Component("docValidator")
public class DocumentExtensionValidator implements ExtensionValidator {

  private static final String[] VALID_EXTENSIONS = {".pdf", ".docx", ".txt"};

  @Override
  public boolean isValid(String fileName) {
    for (String ext : VALID_EXTENSIONS) {
      if (fileName.toLowerCase().endsWith(ext)) {
        return true;
      }
    }
    return false;
  }
}