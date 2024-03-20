import java.io.IOException;
import java.util.Scanner;

public class NewStudentToClass {
    ClassDiary classDiary;
    Attendance ga;
    public NewStudentToClass(ClassDiary classDiary, Attendance ga){
        this.classDiary = classDiary;
        this.ga = ga;
    }

    void addStudentToClass() throws IOException {
        Student newStudent = NewStudent.addNewStudent();
        Scanner sc = new Scanner(System.in);
        System.out.println("Melyik osztályhoz kerüljön? (1b / 3a)");
        String className = sc.nextLine();
        if (className.equals("1b")) {
            classDiary.getClass1B().add(newStudent);
            ga.saveStudentsDataToFile();
        } else if (className.equals("3a")) {
            classDiary.getClass3A().add(newStudent);
            ga.saveStudentsDataToFile();
        } else {
            System.out.println("Nincs ilyen osztály: " + className);
        }

        ga.allStudentsList.add(newStudent);

    }


}