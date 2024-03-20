import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BasicData {

    public static String studentsData() {

        String content = null;


            try {
                content = Files.readString(Paths.get("students-basic-data.json"));
                System.out.println(content);
            } catch (IOException e) {
                System.out.println("Nem található fájl!");
                System.exit(0);
            }

        return content;
    }


    public static String teachersData() {

        String content = null;
        try {
            content = Files.readString(Paths.get("teachers.json"));
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Nem található fájl!");
        }

        return content;
    }
}
