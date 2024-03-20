import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Average {

    Scanner sc = new Scanner(System.in);
    Student foundedStudent = null;
    Finder f = new Finder();

    public Average() throws IOException {
    }

    public void fullAverage() throws IOException {

        System.out.println("Melyik diák jegyátlagát szeretné kiszámítani? (ID)");

        foundedStudent = f.searchingById();
        if (foundedStudent != null) {

            List<Grade> allGrades = foundedStudent.getSubjectsAndGradeMap()
                    .values()
                    .stream()
                    .flatMap(List::stream)
                    .toList();

            double averageGrade = allGrades.stream()
                    .mapToDouble(Grade::getValue)
                    .average()
                    .orElse(0.0);

            System.out.println("Az összes jegy átlaga: " + averageGrade);
        } else {
            System.out.println("Nincs ilyen tanuló.");
        }
    }

    public void averageBySubjects() throws IOException {

        System.out.println("Melyik diák jegyátlagát szeretné kiszámítani tantárgyak szerint? (ID)");

        foundedStudent = f.searchingById();

        System.out.println("Melyik tantárgy jegyátlagát szeretnéd megnézni?");
        Subject selectedSubject = Subject.valueOf(sc.nextLine());

        List<Grade> selectedSubjectGrades = foundedStudent.getSubjectsAndGradeMap().get(selectedSubject);

        if (selectedSubjectGrades != null && !selectedSubjectGrades.isEmpty()) {
            double averageGrade = selectedSubjectGrades.stream()
                    .mapToInt(Grade::getValue)
                    .average()
                    .orElse(0.0);


            System.out.println(selectedSubject + " tantárgy jegyátlaga: " + averageGrade);
        } else {
            System.out.println("A diáknak ebből a tantárgyból nincs jegye!");
        }
    }
}
