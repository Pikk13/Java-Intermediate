import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Finder {

    ClassDiary classDiary = new ClassDiary();

    public Finder() throws IOException {
    }
    Scanner scanner = new Scanner(System.in);
    public Student searchingById() throws IOException {

        List<Student> students = classDiary.loadClassDataFromFileAll();
        students.forEach(System.out::println);
        List<String> iDList = students.stream().map(Student::getId).toList();

        System.out.println("Keresés ID alapján!");
        String iDfinder = scanner.nextLine();

        if (!iDList.contains(iDfinder)) {
            System.out.println("Nincs ilyen ID, próbáld újra!");
            iDfinder = scanner.nextLine();
        }

        String finalIDfinder = iDfinder;
        Student foundedStudent = students.stream()
                .filter(x -> finalIDfinder.equals(x.getId()))
                .findFirst()
                .orElse(null);

        System.out.println(foundedStudent);
        return foundedStudent;
    }
//        KERESŐ VEZETÉKNÉV ALAPJÁN
    public Student searchingByLastName() throws IOException {

        List<Student> students = classDiary.loadClassDataFromFileAll();
        students.forEach(System.out::println);
        List<String> LastNameList = students.stream().map(student1 -> student1.getName().getLastName()).toList();

        System.out.println("Keresés vezetéknév alapján!");
        String lastNameFinder = scanner.nextLine();


        if (!LastNameList.contains(lastNameFinder)) {
            System.out.println("Nincs ilyen név, próbáld újra!");
            lastNameFinder = scanner.nextLine();
        }

        String finalLastNameFinder = lastNameFinder;
        Student foundedStudent = students.stream()
                .filter(x -> finalLastNameFinder.equals(x.getName().getLastName()))
                .findFirst()
                .orElse(null);

        System.out.println(foundedStudent);
        return foundedStudent;
    }
}
