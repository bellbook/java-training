package ch14.ex14_03;

public class Adder {

    private int value;

    public synchronized void add(String name, int arg) {
        value += arg;
        System.out.println(name + ": " + value);
    }

}
