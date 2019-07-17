import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

import com.detectlanguage.DetectLanguage;
import com.detectlanguage.errors.APIError;

public class LangDetector {

    public static void getLangDetected(String resources) throws IOException, APIError {

        DetectLanguage.apiKey = "1b86a6bd0af71de0993509b810811453";

        List<String> filesPathList = FileReader.getFilesPath(resources);

        File file;

        for (String filePath : filesPathList) {

            String langAbrev = DetectLanguage.simpleDetect(FileReader.readFile(filePath));

            System.out.println("Language of: "
                    + new File(filePath).getName()
                    + " : "
                    + langAbrev
                    + " : "
                    + getFullLanguageFromCSV(langAbrev));

        }
    }

    public static String getFullLanguageFromCSV(String langAbrev) throws FileNotFoundException {

        File resourceFile = new File("src\\main\\resources\\languages.csv");

        Scanner scanner = new Scanner(resourceFile).useDelimiter("[,\n]");
        String abrev = "";
        String fullLangDescript = "";
        boolean found = false;

        while (scanner.hasNextLine() && !found) {
            abrev = scanner.next();
            fullLangDescript = scanner.next();

            if (abrev.equals(langAbrev)) {
                found = true;
            }
        }
        return fullLangDescript;
    }
}
