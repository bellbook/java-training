package ch02.ex02_01;

public class Vehicle {

    public int speed = 0;
    public int direction = 0;
    public String owner = null;

    @Override
    public String toString() {
        return "Vehicle [speed=" + speed + ", direction=" + direction
                + ", owner=" + owner + "]";
    }

}
