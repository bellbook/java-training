package ch04.ex04_01;

public class GasTank implements EnergySource {

    private int gas;

    public GasTank(int gas) {
        this.gas = gas;
    }

    @Override
    public boolean empty() {
        return gas <= 0;
    }

}
