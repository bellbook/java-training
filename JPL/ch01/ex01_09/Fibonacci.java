package ch01.ex01_09;

public class Fibonacci {

    public static void exec() {
        int[] array = new int[9];

        int lo = 1;
        int hi = 1;

        array[0] = lo;
        for (int i = 1; hi < 50; i++) {
            array[i] = hi;
            hi = lo + hi;
            lo = hi - lo;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
