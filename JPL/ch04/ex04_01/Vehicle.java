package ch04.ex04_01;

public class Vehicle {

    public static void main(String[] args) {
        GasTank g1 = new GasTank(0);
        GasTank g2 = new GasTank(100);

        Battery b1 = new Battery(0);
        Battery b2 = new Battery(100);

        Vehicle[] v = { new Vehicle(g1),
                new Vehicle(g2),
                new Vehicle(b1),
                new Vehicle(b2) };

        for (int i = 0; i < v.length; i++) {
            v[i].start();
        }
    }

    private int speed = 0;
    private int direction = 0;
    private String owner = null;

    private static int nextID = 0;
    private int id;

    public static final String TURN_LEFT = "left";
    public static final String TURN_RIGHT = "right";

    private EnergySource energy;

    public Vehicle() {
        id = nextID++;
    }

    public Vehicle(String owner) {
        this();
        this.owner = owner;
    }

    public Vehicle(EnergySource energy) {
        this();
        this.energy = energy;
    }

    public void changeSpeed(int speed) {
        this.speed = speed;
    }

    public void stop() {
        this.speed = 0;
    }

    public void turn(int direction) {
        this.direction += direction;
    }

    public void turn(final String str) {
        if (str.equals(TURN_LEFT)) {
            turn(-90);
        } else if (str.equals(TURN_RIGHT)) {
            turn(90);
        } else {

        }
    }

    public void start() {
        if (energy.empty()) {
            System.out.println("Energy is empty.");
        } else {
            System.out.println("Start!");
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public static int getMaxID() {
        return nextID - 1;
    }

    @Override
    public String toString() {
        return "Vehicle [speed=" + speed + ", direction=" + direction
                + ", owner=" + owner + ", id=" + id + "]";
    }

}
