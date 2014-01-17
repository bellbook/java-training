package ch02.ex02_06;

public class Vehicle {

    public int speed = 0;
    public int direction = 0;
    public String owner = null;

    public static int nextID = 0;
    public final int id;

    public Vehicle() {
        id = nextID++;
    }

    @Override
    public String toString() {
        return "Vehicle [speed=" + speed + ", direction=" + direction
                + ", owner=" + owner + ", id=" + id + "]";
    }

}
