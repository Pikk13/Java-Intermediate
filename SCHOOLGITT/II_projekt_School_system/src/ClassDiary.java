import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ClassDiary extends Student {


    private Teacher headTeacher;
    private String nameOfClass;
    private List<Student> studentList = new ArrayList<>();
    private List<Student> class1B = new ArrayList<>();
    private List<Student> class3A = new ArrayList<>();

    Student student1 = new Student("001", new Name("Sean", "Austin"), false, 0);
    Student student2 = new Student("002", new Name("Elijah", "Wood"), false, 0);
    Student student3 = new Student("003", new Name("Billy", "Boyd"), false, 0);
    Student student4 = new Student("004", new Name("Dominic", "Monaghan"),false, 0);


    public ClassDiary(List<Student> newlyAddedStudents) {
        this.studentList.addAll(newlyAddedStudents);
//        fillingClass1B();
//        fillingClass3A();
    }

    private void fillingClass1B(){
        class1B.add(student1);
        class1B.add(student2);
    }
    private void fillingClass3A(){
        class3A.add(student3);
        class3A.add(student4);
    }

    boolean validInput = false;

    public ClassDiary() throws IOException {

        loadClassDataFromFile1b();
    }


    public void saveClassDataToFile1b() throws IOException {
        List<Student> oneB = new ArrayList<>(loadClassDataFromFile1b());
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String dataToJson = prettyGson.toJson(oneB);

        try {
            FileWriter fw = new FileWriter("ClassDataNewest1b.json");
            fw.write(dataToJson);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveClassDataToFile3a() {
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String dataToJson = prettyGson.toJson(class3A);

        try {
            FileWriter fw = new FileWriter("ClassDataNewest3a.json");
            fw.write(dataToJson);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> loadClassDataFromFileAll() throws IOException {

        String content = Files.readString(Paths.get("StudentsDataNewest.json"));
        Gson gs = new Gson();
        Type listType = new TypeToken<List<Student>>() {
        }.getType();
        List<Student> loadStudents = gs.fromJson(content, listType);




        return loadStudents;
    }


    public List<Student> loadClassDataFromFile1b() throws IOException {
        class1B.clear();
        String content = Files.readString(Paths.get("ClassDataNewest1b.json"));
        Gson gs = new Gson();
        Type listType = new TypeToken<List<Student>>() {
        }.getType();
        List<Student> loadStudents1b = gs.fromJson(content, listType);

        class1B.addAll(loadStudents1b);


        return loadStudents1b;
    }


    public List<Student> loadClassDataFromFile3a() throws IOException {
        class3A.clear();
        String content = Files.readString(Paths.get("ClassDataNewest3a.json"));
        Gson gs = new Gson();
        Type listType = new TypeToken<List<Student>>() {
        }.getType();
        List<Student> loadStudents3a = gs.fromJson(content, listType);

        class3A.addAll(loadStudents3a);

        return loadStudents3a;
    }
    void classData() throws IOException {

        int choosingClass = 0;
        do {


            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Melyik osztály naplójához szeretne hozzáférést kapni?");
                System.out.println("1: 1B , 2: 3A");
                choosingClass = scanner.nextInt();

                if (choosingClass < 1 || choosingClass > 2) {
                    System.out.println("Nincs ilyen választási lehetőség, válasszon bölcsebben!" + "\n");

                } else validInput = true;
            } catch (
                    InputMismatchException mismatchException) {
                System.out.println("Nem megfelelő karaktert írt be, cselekedjen bölcsebben!" + "\n");

            }
        } while (!validInput);

        if (choosingClass == 1) {
            System.out.println("Az 1B osztály naplója: ");

            System.out.print("Osztályfőnök: ");
            Teacher headTeacher1B = new Teacher(new Name("István", "Raffai"));
            System.out.println(headTeacher1B);


            System.out.println("Az 1/B osztály névsora: ");

            loadClassDataFromFileAll().forEach(System.out::println);

//            class1B.forEach(System.out::println);
//           loadClassDataFromFile1b();

        } else if (choosingClass == 2) {


            System.out.println("A 3A osztály naplója: ");

            System.out.print("Osztályfőnök: ");
            Teacher headTeacher3A = new Teacher(new Name("Tünde", "Ugri"));
            System.out.println(headTeacher3A);


            System.out.println("A 3/A osztály névsora: ");
            loadClassDataFromFile3a();

            String content = Files.readString(Paths.get("ClassDataNewest3a.json"));
            Gson gs = new Gson();
            Type listType = new TypeToken<List<Student>>() {
            }.getType();
            List<Student> loadStudents1b = gs.fromJson(content, listType);


            class3A.addAll(loadStudents1b);

            class3A.forEach(System.out::println);
        }
    }


    public ClassDiary(Teacher headTeacher, String nameOfClass) {
        this.headTeacher = headTeacher;
        this.nameOfClass = nameOfClass;


    }

    public List<Student> getClass1B() {
        return class1B;
    }

    public void setClass1B(List<Student> class1B) {
        this.class1B = class1B;
    }

    public List<Student> getClass3A() {
        return class3A;
    }

    public void setClass3A(List<Student> class3A) {
        this.class3A = class3A;
    }

    public Teacher getHeadTeacher() {
        return headTeacher;
    }

    public void setHeadTeacher(Teacher headTeacher) {
        this.headTeacher = headTeacher;
    }

    public String getNameOfClass() {
        return nameOfClass;
    }

    public void setNameOfClass(String nameOfClass) {
        this.nameOfClass = nameOfClass;
    }


    @Override
    public String toString() {
        return "ClassDiary{" +
                "headTeacher=" + headTeacher +
                ", nameOfClass='" + nameOfClass + '\'' +

                '}';
    }
}
