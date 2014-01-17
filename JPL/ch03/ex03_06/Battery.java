package ch03.ex03_06;

public class Battery extends EnergySource {

    private int battery;

    public Battery(int battery) {
        this.battery = battery;
    }

    @Override
    public boolean empty() {
        return battery <= 0;
    }

}
