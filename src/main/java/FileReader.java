import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileReader {

    public static String readFile(String filePath) throws FileNotFoundException {

        File file = new File(filePath);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("You're reading: " + file.getName() + "\n");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            stringBuffer.append(scanner.nextLine() + "\n");
        }
        stringBuffer.append("\nTHE END\n");
        return stringBuffer.toString();
    }

    public static List<String> getFilesPath(String resourcesPath) throws IOException {

        List<String> filesList = Files.walk(Paths.get(resourcesPath))
                .filter(Files::isRegularFile)
                .map(file -> file.toString())
                .collect(Collectors.toList());
        return filesList;
    }

    public static void readAllFiles(String resourcesPath) throws IOException {
        List<String> filesPathList = getFilesPath(resourcesPath);

        for (String filePath : filesPathList) {
            System.out.println(readFile(filePath));
        }
    }
}



