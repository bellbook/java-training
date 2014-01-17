package ch03.ex03_09;

public class Garage implements Cloneable {

    public static void main(String[] args) {

        Vehicle car1 = new Vehicle("Beckham");
        Vehicle car2 = new Vehicle("Beck");
        Vehicle car3 = new Vehicle("Be");

        Garage g = new Garage(2);

        g.push(car1);
        g.push(car2);

        Garage newG = g.clone();
        Garage newG0 = g.clone0();

        g.pop();
        g.push(car3);

        System.out.println(g);
        System.out.println(newG);
        System.out.println(newG0);
    }

    private Vehicle[] buffer;
    private int top;

    public Garage(int maxVehicle) {
        buffer = new Vehicle[maxVehicle];
        top = -1;
    }

    public void push(Vehicle val) {
        buffer[++top] = val;
    }

    public Vehicle pop() {
        return buffer[top--];
    }

    public Garage clone() {
        try {
            Garage g = (Garage) super.clone();
            g.buffer = new Vehicle[buffer.length];
            for (int i = 0; i <= top; i++)
                g.buffer[i] = (Vehicle) buffer[i].clone();
            return g;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }

    public Garage clone0() {
        try {
            return (Garage) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }

    @Override
    public String toString() {

        String s = "Garage\r\n";

        for (int i = 0; i <= top; i++) {
            s += buffer[i].toString() + "\r\n";
        }

        return s;
    }

}
