package ch03.ex03_08;

public class PassengerVehicle extends Vehicle {

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
