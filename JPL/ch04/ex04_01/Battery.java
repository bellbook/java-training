package ch04.ex04_01;

public class Battery implements EnergySource {

    private int battery;

    public Battery(int battery) {
        this.battery = battery;
    }

    @Override
    public boolean empty() {
        return battery <= 0;
    }

}
