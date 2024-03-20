import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;


public class Attendance {

    private LocalDate currentDate;

    public Attendance() throws IOException {
        this.currentDate = LocalDate.now();
        loadStudentsSchoolDataFromFile();

    }
    List<Student> allStudentsList = new ArrayList<>();



    public List<Student> loadStudentsSchoolDataFromFile() throws IOException {
        String content = Files.readString(Paths.get("StudentsDataNewest.json"));
        Gson gs = new Gson();
        Type listType = new TypeToken<List<Student>>() {
        }.getType();
        List<Student> loadStudents = gs.fromJson(content, listType);
//        loadStudents.forEach(System.out::println);
        allStudentsList.clear();
        allStudentsList.addAll(loadStudents);

        return allStudentsList;
    }

    public void saveStudentsDataToFile() {
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String dataToJson = prettyGson.toJson(allStudentsList);

        try {
            FileWriter fw = new FileWriter("StudentsDataNewest.json");
            fw.write(dataToJson);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFile() throws IOException {
        Files.delete(Path.of("StudentsDataNewest.json"));
    }

    public void markAttendance() throws IOException {

        System.out.println("Mai dátum (év-hónap-nap): " + getCurrentDate());
        ClassDiary classDiary = new ClassDiary(allStudentsList);




        for (Student newStudent : Arrays.asList(classDiary.student1, classDiary.student2, classDiary.student3, classDiary.student4)) {
            Optional<Student> existingStudent = allStudentsList.stream()
                    .filter(student -> student.getId().equals(newStudent.getId()))
                    .findFirst();

            if (existingStudent.isPresent()) {
                Student studentToUpdate = existingStudent.get();
                studentToUpdate.setName(newStudent.getName());
            } else {
                allStudentsList.add(newStudent);
            }
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Új diák bevitele az iskolai rendszerbe? (yes/no)");
                String newStudentToSystem = sc.nextLine();
        if (newStudentToSystem.equals("yes")) {

        System.out.println("Az új tanuló ID-ja: ");
        String newId = sc.nextLine();
        System.out.println("Vezetéknév: ");
        String lastName = sc.nextLine();
        System.out.println("Keresztnév: ");
        String firstName = sc.nextLine();

        Student newGuy = new Student(newId, new Name(firstName, lastName), false, 0);

        System.out.println("Melyik osztályhoz kerüljön? (1b / 3a)");
        String className = sc.nextLine();

        if (className.equals("1b")) {
            for (Student student : allStudentsList) {
                classDiary.getClass1B().add(student);
            }

            if (!classDiary.getClass1B().contains(newGuy)) {
                allStudentsList.add(newGuy);
                classDiary.getClass1B().add(newGuy);
                saveStudentsDataToFile();
                classDiary.saveClassDataToFile1b();
            } else {
                System.out.println("Ez a diák már hozzá van adva az 1B osztályhoz.");
            }
        } else if (className.equals("3a")) {
            for (Student student : allStudentsList) {
                classDiary.getClass3A().add(student);
            }

            if (!classDiary.getClass3A().contains(newGuy)) {
                allStudentsList.add(newGuy);
                classDiary.getClass3A().add(newGuy);
                saveStudentsDataToFile();
                classDiary.saveClassDataToFile3a();
            } else {
                System.out.println("Ez a diák már hozzá van adva a 3A osztályhoz.");
            }
        } else {
            System.out.println("Nincs ilyen osztály: " + className);
        }
        }

        classDiary.classData();  // BEOLVASSA A SCANNERT AZ OSZTÁLY KIVÁLASZTÁSÁRA
        AttendanceSC.attendScan(); // HIÁNYZÓK KEZELÉSE
        Grade.addNewGrade(); // ÚJ JEGY BEÍRÁSA


//       List<Student> allThePeople = classDiary.loadClassDataFromFileAll();
//
//        classDiary.getClass1B().clear();
////        classDiary.getClass3A().clear();
//
//        classDiary.getClass1B().addAll(allThePeople);



    }







    public void absences(Student student) {

        System.out.println(student.getName() + " hiányzásainak száma a tanév során: " + student.getNumberOfAbsences());
    }


    public LocalDate getCurrentDate() {
        return currentDate;
    }
}

//        System.out.println("Mai dátum (év-hónap-nap): " + getCurrentDate());
//
//        ClassDiary classDiary = new ClassDiary();
//
//
//        allStudentsList.add(classDiary.student1);
//        allStudentsList.add(classDiary.student2);
//        allStudentsList.add(classDiary.student3);
//        allStudentsList.add(classDiary.student4);
//
//        classDiary.classData();
//
////        List<Student> egyB = classDiary.getClass1B();
////        List<Student> haromA = classDiary.getClass3A();
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Melyik diák nincs jelen az órán? (ID)");
//        String input = scanner.nextLine();
//        System.out.println("*******************");
//
//        Optional<Student> foundStudent = allStudentsList.stream()
//                .filter(student -> student.getId().equals(input))
//                .findFirst();
//
//        if (foundStudent.isPresent()) {
//            Student student = foundStudent.get();
//            student.setNumberOfAbsences(student.getNumberOfAbsences() + 1);
//            saveStudentsDataToFile();
//            absences(student);
//        } else {
//            System.out.println("Nem található diák az adott ID-vel.");
//        }


//************************************
//        List<Student> foundStudents = allStudentsList.stream()
//                .filter(student -> student.getId().equals(input))
//                .collect(Collectors.toList());
//        if (!foundStudents.isEmpty()) {
//            Student foundStudent = foundStudents.get(0);
////            foundStudent.setAbsent(true);
//            foundStudent.setNumberOfAbsences(foundStudent.getNumberOfAbsences()+1);
//            saveStudentsDataToFile();
//            absences(foundStudent);
//        } else {
//            System.out.println("Nem található diák az adott ID-vel.");
//        }


//        allStudentsList.forEach(System.out::println);