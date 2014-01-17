package ch02.ex02_01;

public class Ex02_01 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.speed = 100;
        vehicle.direction = 60;
        vehicle.owner = "Jack";
        System.out.println(vehicle);
    }

}
