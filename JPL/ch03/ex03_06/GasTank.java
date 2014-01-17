package ch03.ex03_06;

public class GasTank extends EnergySource {

    private int gas;

    public GasTank(int gas) {
        this.gas = gas;
    }

    @Override
    public boolean empty() {
        return gas <= 0;
    }

}
