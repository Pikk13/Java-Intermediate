
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Student {

    private String id;
    private Name name;
    private Map<Subject, List<Grade>> subjectsAndGradeMap = new HashMap<>();
    private boolean isAbsent;
    private int numberOfAbsences;

    public boolean isAbsent() {
        return isAbsent;
    }

    public void setAbsent(boolean absent) {
        isAbsent = absent;
    }

    public Student(String id, Name name, boolean isAbsent, int numberOfAbsences) {
        this.id = id;
        this.name = name;
        this.isAbsent = isAbsent;
        this.numberOfAbsences=numberOfAbsences;
    }

    public Student() {
    }

    public Student(String id, Name name){
        this.id = id;
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfAbsences() {
        return numberOfAbsences;
    }

    public void setNumberOfAbsences(int numberOfAbsences) {
        this.numberOfAbsences = numberOfAbsences;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    static void saveStudentsDataToFile(List<Student> everyBody) {
        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        String dataToJson = prettyGson.toJson(everyBody);

        try {
            FileWriter fw = new FileWriter("StudentsDataNewest.json");
            fw.write(dataToJson);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    static List<Student> allTheMan() throws IOException {
        ClassDiary classDiary = new ClassDiary();
        List<Student> everyBody = classDiary.loadClassDataFromFileAll();


        for (Student student: everyBody) {
            student.subjectsAndGradeMap.put(Subject.BIOLOGY,Grade.randomGrades());
            student.subjectsAndGradeMap.put(Subject.GEOGRAPHY,Grade.randomGrades());
            student.subjectsAndGradeMap.put(Subject.HISTORY,Grade.randomGrades());
            student.subjectsAndGradeMap.put(Subject.MATH,Grade.randomGrades());
        }
        Student.saveStudentsDataToFile(everyBody);
        everyBody.forEach(System.out::println);

        return everyBody;
    }


    public Map<Subject, List<Grade>> getSubjectsAndGradeMap() throws IOException {


//        subjectsAndGradeMap.put(Subject.GEOGRAPHY, Grade.randomGrades());
//        subjectsAndGradeMap.put(Subject.BIOLOGY, Grade.randomGrades());
//        subjectsAndGradeMap.put(Subject.HISTORY, Grade.randomGrades());
//        subjectsAndGradeMap.put(Subject.MATH, Grade.randomGrades());
        return subjectsAndGradeMap;
    }

    public void setSubjectsAndGradeMap(Map<Subject, List<Grade>> subjectsAndGradeMap) {
        this.subjectsAndGradeMap = subjectsAndGradeMap;
    }


    @Override
    public String toString() {
        return "A tanulói azonosító: " + id + '\'' +
                ", Név: " + name + ", " +
                subjectsAndGradeMap
                +
//                (isAbsent ? "Hiányzik" : "Jelen van" ) +
                " ,Hiányzásainak száma a tanév során: " + numberOfAbsences
        ;
    }


}
