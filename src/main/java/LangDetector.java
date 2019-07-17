import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.errors.APIError;

public class LangDetector {

    public static void getLangDetected(String resources) throws IOException, APIError {

        DetectLanguage.apiKey = "1b86a6bd0af71de0993509b810811453";

        List<String> filesPathList = FileReader.getFilesPath(resources);

        File file;

        for (String filePath : filesPathList) {
            System.out.println("Language of: "
                    + new File(filePath).getName()
                    + " : "
                    + DetectLanguage.simpleDetect(FileReader.readFile(filePath)));
        }
    }
}
