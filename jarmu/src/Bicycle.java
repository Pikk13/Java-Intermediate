import java.util.Scanner;

public class Bicycle extends Vehicle {


    public Bicycle(double weight, double maxSpeed, boolean isItBroken) {
        super(weight, maxSpeed, isItBroken);
    }

    static double whatIsWeight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mekkora a bringa súya?");
        double suly = sc.nextDouble();
        sc.close();
        return suly;
    }


    BrokenException brokenException = new BrokenException();


    @Override
    public void start() {

        try {
            if (!isItBroken()) {
                System.out.println("A bringának semmi baja, lóra fel");
            } else throw brokenException;
        } catch (BrokenException brokenException) {
            System.out.println("Valamiyen alkatrész megsérült, nem lehet elindulni");
        }
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "} " + super.toString();
    }
}
