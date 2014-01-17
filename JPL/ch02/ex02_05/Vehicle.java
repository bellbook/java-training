package ch02.ex02_05;

public class Vehicle {

    public int speed = 0;
    public int direction = 0;
    public String owner = null;

    public static int nextID = 0;
    public final int id;

    public static void main(String[] args) {

        Vehicle car = new Vehicle();
        car.speed = 100;
        car.direction = 60;
        car.owner = "Jack";
        System.out.println("car  = " + car);

        Vehicle bike = new Vehicle();
        bike.speed = 180;
        bike.direction = 30;
        bike.owner = "Mike";
        System.out.println("bike = " + bike);
    }

    public Vehicle() {
        id = nextID++;
    }

    @Override
    public String toString() {
        return "Vehicle [speed=" + speed + ", direction=" + direction
                + ", owner=" + owner + ", id=" + id + "]";
    }

}
