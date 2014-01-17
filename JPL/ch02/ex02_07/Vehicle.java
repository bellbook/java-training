package ch02.ex02_07;

import ch02.ex02_07.Vehicle;

public class Vehicle {

    public int speed = 0;
    public int direction = 0;
    public String owner = null;

    public static int nextID = 0;
    public int id;

    public static void main(String[] args) {

        Vehicle car = new Vehicle("Jack");
        car.speed = 100;
        car.direction = 60;
        System.out.println("car  = " + car);

        Vehicle bike = new Vehicle("Mike");
        bike.speed = 180;
        bike.direction = 30;
        System.out.println("bike = " + bike);
    }

    public Vehicle() {
        id = nextID++;
    }

    public Vehicle(String owner) {
        this();
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle [speed=" + speed + ", direction=" + direction
                + ", owner=" + owner + ", id=" + id + "]";
    }

}
