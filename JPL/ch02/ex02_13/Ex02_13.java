package ch02.ex02_13;

public class Ex02_13 {

    public static void main(String[] args) {

        Vehicle car = new Vehicle("Jack");
        car.setSpeed(100);
        car.setDirection(60);
        System.out.println("car = " + car);
        System.out.println("maxID = " + Vehicle.getMaxID());

        Vehicle bike = new Vehicle("Mike");
        bike.setSpeed(180);
        bike.setDirection(30);
        System.out.println("bike = " + bike);
        System.out.println("maxID = " + Vehicle.getMaxID());
    }

}
