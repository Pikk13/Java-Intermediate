import java.io.IOException;
import java.util.*;

public class Grade {

    private int value;

    public Grade(int value) {
        if (value < 1 || value > 5) {
            throw new IllegalArgumentException("Az osztályzatnak 1 és 5 között kell lennie.");
        }
        this.value = value;
    }

    public static List<Grade> randomGrades() {
        List<Grade> gradeList = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i < 6; i++) { //5 jegy random beírása
            int randomGrade = random.nextInt(1, 6);
            gradeList.add(new Grade(randomGrade));
        }
//        System.out.println(gradeList);
        return gradeList;
    }

public static void addNewGrade() throws IOException {
    boolean validInput = false;

    do {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Melyik diáknak szeretne jegyet beírni? (ID) / Ha egyiknek sem, akkor: 0");
            String input = scanner.nextLine();
            System.out.println("*******************");

            Attendance attendance = new Attendance();
            Optional<Student> foundStudent = attendance.allStudentsList.stream()
                    .filter(student -> student.getId().equals(input))
                    .findFirst();

            if (foundStudent.isPresent()) {
                // tantárgyválasztás
                System.out.println("Melyik tantárgy?");
                Subject[] tantargyLista = Subject.values();
                for (Subject tantargy : tantargyLista) {
                    System.out.println(tantargy.name);
                }

                Scanner scanner1 = new Scanner(System.in);
                Subject subject = Subject.valueOf(scanner1.nextLine());

                // osztályzat
                boolean validInput2 = false;
                do {
                    try {
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Írja be az osztályzatot a tanulónak? (1-5-ig)");
                        int gradeValue = scanner2.nextInt();



                        if (gradeValue < 1 || gradeValue > 5) {
                            System.out.println("Nem megfelelő osztályzat, válasszon 1 és 5 között!");
                        } else {
                            Grade newGrade = new Grade(gradeValue);
                            Student student = foundStudent.get();
                            List<Grade> gradeList = student.getSubjectsAndGradeMap().computeIfAbsent(subject, x -> new ArrayList<>());
                            gradeList.add(newGrade);
                            attendance.saveStudentsDataToFile();
                            validInput2 = true;
                        }
                    } catch (InputMismatchException mismatchException) {
                        System.out.println("Nem megfelelő karaktert írt be, cselekedjen bölcsebben!" + "\n");
                    }
                } while (!validInput2);
            }
            if (input.equals("0")) validInput = true;
        } catch (NoSuchElementException noSuchElementException) {
            System.out.println("Ilyen ID nem létezik!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } while (!validInput);
}


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "" + value;
    }
}
