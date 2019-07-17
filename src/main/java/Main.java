import com.detectlanguage.DetectLanguage;
import com.detectlanguage.errors.APIError;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, APIError {

        String resourcesPath = "src\\main\\resources\\";

        LangDetector.getLangDetected(resourcesPath);
    }
}
