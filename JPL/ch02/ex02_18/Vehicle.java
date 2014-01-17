package ch02.ex02_18;

public class Vehicle {

    private int speed = 0;
    private int direction = 0;
    private String owner = null;

    private static int nextID = 0;
    private int id;

    public static final String TURN_LEFT = "left";
    public static final String TURN_RIGHT = "right";

    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
        Vehicle car = new Vehicle(args[0]);
        System.out.println(car);
    }

    public Vehicle() {
        id = nextID++;
    }

    public Vehicle(String owner) {
        this();
        this.owner = owner;
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
