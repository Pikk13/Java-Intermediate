public final class Car extends Vehicle implements Motorized {

    private double fuelQuantity;

    public Car(double weight, double maxSpeed, boolean isItBroken, double fuelQuantity) {
        super(weight, maxSpeed, isItBroken);
        this.fuelQuantity = 50.0;

    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    BrokenException brokenException = new BrokenException();
    NoFuelException noFuelException = new NoFuelException();

    @Override
    public void start() {

        try {
            if (!isItBroken()) {
                System.out.println("Minden rendben a kocsival, útra kelhet!");
                fuelQuantity -= 25;
            } else if (fuelQuantity <= 0) {
                throw noFuelException;
            }
            else throw brokenException;
        } catch (Exception | BrokenException e) {
            System.out.println("Egyik alkatrészt károsodás érte, vagy kifogyott az üzemanyag");
        System.exit(0);}
    }

    @Override
    public void fuelFilling(int number) {

        System.out.println("Tankolás a MOL-kúton: " + (fuelQuantity += number) + " lityó benya");

    }

    @Override
    public int getFuel() {

        return (int) fuelQuantity;
    }
}
