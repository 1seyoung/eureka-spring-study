package validator;

import org.springframework.stereotype.Component;

@Component("imageValidator")
public class ImageExtensionValidator implements ExtensionValidator {

  private static final String[] VALID_EXTENSIONS = {".jpg", ".jpeg", ".png", ".gif"};

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
