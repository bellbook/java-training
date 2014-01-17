package ch01.ex01_12;

public class ImprovedFibonacci {

    static final int MAX_INDEX = 9;

    public static void exec() {
        int lo = 1;
        int hi = 1;
        String mark;

        String[] message = new String[MAX_INDEX];

        message[0] = "1: " + lo;
        for (int i = 2; i <= MAX_INDEX; i++) {
            if (hi % 2 == 0)
                mark = "*";
            else
                mark = "";
            message[i - 1] = i + ": " + hi + mark;
            hi = lo + hi;
            lo = hi - lo;
        }

        for (String i : message) {
            System.out.println(i);
        }
    }

}
