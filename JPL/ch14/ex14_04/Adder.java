package ch14.ex14_04;

public class Adder {

    private static int value;

    public static synchronized void add(String name, int arg) {
        value += arg;
        System.out.println(name + ": " + value);
    }

}
