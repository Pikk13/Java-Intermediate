import java.io.IOException;

public abstract class Vehicle {

    private double weight;
    private double maxSpeed;
    private boolean isItBroken;

    public Vehicle(double weight, double maxSpeed, boolean isItBroken) {
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.isItBroken = isItBroken;
    }


    public abstract void start() throws BrokenException;


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isItBroken() {
        return isItBroken;
    }

    public void setItBroken(boolean itBroken) {
        isItBroken = itBroken;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "weight=" + weight +
                ", maxSpeed=" + maxSpeed +
                ", isItBroken=" + isItBroken +
                '}';
    }
}
