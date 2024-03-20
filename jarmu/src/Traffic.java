import java.util.ArrayList;
import java.util.List;

public class Traffic {


    public static void main(String[] args) {

        List<Vehicle> vehicleList = new ArrayList<>();
        Bicycle bike1 = new Bicycle(12.2, 40.0, false);
        Bicycle bike2 = new Bicycle(Bicycle.whatIsWeight(), 40.0, true);
        Car car1 = new Car(789.55, 220.5, false, 50.0);
        Car car2 = new Car(1000.0, 260.0, true, 50.0);

        vehicleList.add(bike1);
        vehicleList.add(bike2);
        vehicleList.add(car1);
        vehicleList.add(car2);



//        car1.start();
//        car2.start();

        System.out.println(bike1);
        bike1.start();
        System.out.println(bike2);
        bike2.start();


        System.out.println(car1);
        System.out.println();
        System.out.println("AMÍG NEM PORZIK A TANK");
        System.out.println();

        startingVehicleStillHasGotFuel(car1);


        System.out.println();
        System.out.println("FUEL FILLING");
        System.out.println();
        car1.fuelFilling(75);

        startingVehicleStillHasGotFuel(car1);
    }

    static void startingVehicleStillHasGotFuel(Car car) {

        double noMoreFuel = 0.0;
        while (car.getFuelQuantity() > noMoreFuel) {
            System.out.println("Az üzemanyag mennyisége: " + car.getFuelQuantity() + " liter");
            car.start();
        }

        System.out.println("Az üzemanyag mennyisége: " + car.getFuel() + " liter");
        if (car.getFuelQuantity() <= noMoreFuel) System.out.println("Elfogyott az üzemanyag, kényszermegállás!");
    }
}