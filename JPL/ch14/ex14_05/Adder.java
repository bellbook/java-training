package ch14.ex14_05;

public class Adder {

    private static int value;

    public static void add(String name, int arg) {

        synchronized (Adder.class) {
            value += arg;
            System.out.println(name + ": " + value);
        }
    }

}
