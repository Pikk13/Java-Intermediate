
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class ScannerClass {

    public static int whatToDo() throws IOException {
        int operation = 0;
        boolean validInput = false;
        boolean continueRunning = true;
        Average average = new Average();
        Attendance attendance = new Attendance();
        Finder finder = new Finder();
        while (continueRunning) {
            do {
                try {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Választható műveletek az iskolai nyilvántartásban:" + "\n");

                    System.out.println(
                            "0. Lépjen ki a nyilvántartó rendszerből!" + "\n" +
                                    "1. Diákok személyes adatainak/elérhetőségek listája" + "\n" +
                                    "2. Tanárok listája tantárgyak szerint" + "\n" +
                                    "3. Hozzáférés az osztálynaplókhoz: új diák felvétele, jegybeírás, hiányzás" + "\n" +
                                    "4. Választott tanuló érdemjegyeinek átlaga" + "\n" +
                                    "5. Diákok érdemjegyeinek átlaga tantárgyanként" + "\n" +
                                    "6. Diák keresése vezetéknév alapján " + "\n");

                    System.out.println("Hányas sorszámú műveletet szeretné végrehajtani?");
                    operation = scan.nextInt();
                    if (operation < 0 || operation > 9) {
                        System.out.println("Nincs ilyen választási lehetőség, válasszon bölcsebben!" + "\n");

                    } else validInput = true;
                } catch (InputMismatchException mismatchException) {
                    System.out.println("Nem megfelelő karaktert írt be, cselekedjen bölcsebben!" + "\n");

                }
            } while (!validInput);

            switch (operation) {
                case 1:
                    BasicData.studentsData();
                    break;
                case 2:
                    BasicData.teachersData();
                    break;
                case 3:
                    attendance.markAttendance();
                    break;
                case 4:
                    average.fullAverage();
                    break;
                case 5:
                    average.averageBySubjects();
                    break;
                case 6:
                    finder.searchingByLastName();
                    break;

                case 0:
                    System.out.println("Kilépés a nyilvántartóból, adatok mentése.");
                    continueRunning = false;
                    break;
            }

        }
        return operation;
    }
}
