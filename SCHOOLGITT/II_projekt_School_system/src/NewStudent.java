import java.util.Scanner;

public class NewStudent {
    static Student addNewStudent(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Az új tanuló ID-ja: ");
        String newId = sc.nextLine();
        System.out.println("Vezetéknév: ");
        String lastName = sc.nextLine();
        System.out.println("Keresztnév: ");
        String firstName = sc.nextLine();

        Student newGuy = new Student(newId, new Name(firstName, lastName), false, 0);
        return newGuy;
    }
}
