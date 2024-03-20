import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class AttendanceSC {
   static void attendScan() throws IOException {
       Attendance attendance = new Attendance();
       ClassDiary classDiary = new ClassDiary(attendance.loadStudentsSchoolDataFromFile());

        boolean validInput = false;
        do {

            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Van hiányzó? (ID) / Ha nincs, akkor írja be, hogy: nincs");
                String input = scanner.nextLine();
//                System.out.println("*******************");
//                Attendance attendance = new Attendance();
                Student foundStudent = attendance.allStudentsList.stream()
                        .filter(student -> student.getId().equals(input))
                        .findFirst().orElse(null);



//                System.out.println(foundStudent);

               if (foundStudent!= null){
                foundStudent.setNumberOfAbsences(foundStudent.getNumberOfAbsences() + 1);

                    attendance.saveStudentsDataToFile();

                    List<Student> class1b = classDiary.loadClassDataFromFile1b();
                   Student foundStudent1b = class1b.stream()
                           .filter(student -> student.getId().equals(input))
                           .findFirst().orElse(null);
//                   System.out.println("A class1b kiíratása");
//                   classDiary.getClass1B().forEach(System.out::println);
//                   if (class1b.isEmpty()) System.out.println("a class1b ÜRES*********!!!!!!!!!!!!!!!!!!!!");
//                   if (!class1b.contains(foundStudent1b)) System.out.println("A class1B-ben nem található a foundstudent");
                   if (class1b.contains(foundStudent1b)){

                      List<Student> allThePeople = attendance.loadStudentsSchoolDataFromFile();
                    attendance.saveStudentsDataToFile();
                      class1b.add(allThePeople.get(allThePeople.size()-1));
//                       System.out.println("ÚJ CLASS 1B");
                      allThePeople.forEach(System.out::println);
                       attendance.absences(foundStudent);

                        } else if (classDiary.getClass3A().contains(foundStudent)) {
                            classDiary.saveClassDataToFile3a();
                        }

                   classDiary.saveClassDataToFile1b();
                } else if (input != null && input.equals("nincs")) {
                    validInput = true;
                }
            } catch (NoSuchElementException noSuchElementException) {
                System.out.println("Ilyen ID nem létezik!");
            }
        } while (!validInput);
    }





}
