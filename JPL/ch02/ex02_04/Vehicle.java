package ch02.ex02_04;

public class Vehicle {

    public int speed = 0;
    public int direction = 0;
    public String owner = null;

    public static int nextID = 0;
    public final int id; // 変更がなさそうなのでfinalにすべき

    public Vehicle() {
        id = nextID++;
    }

}
