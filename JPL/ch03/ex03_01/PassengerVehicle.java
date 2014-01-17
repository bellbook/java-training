package ch03.ex03_01;

public class PassengerVehicle extends Vehicle {

    public static void main(String[] args) {

        PassengerVehicle taxi = new PassengerVehicle("Beckham");
        taxi.setSeatNum(5);
        taxi.setPassengerNum(3);
        System.out.println(taxi);

        PassengerVehicle bus = new PassengerVehicle("John");
        bus.setSeatNum(20);
        bus.setPassengerNum(1);
        System.out.println(bus);
    }

    private int seatNum;
    private int passengerNum;

    public PassengerVehicle(String owner) {
        super(owner);
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public int getPassengerNum() {
        return passengerNum;
    }

    public void setPassengerNum(int passengerNum) {
        this.passengerNum = passengerNum;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "PassengerVehicle [seatNum=" + seatNum
                + ", passengerNum=" + passengerNum + "]";
    }

}
