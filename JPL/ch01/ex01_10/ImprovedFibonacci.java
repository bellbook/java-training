package ch01.ex01_10;

public class ImprovedFibonacci {

    static final int MAX_INDEX = 9;

    public static void exec() {
        Result[] array = new Result[MAX_INDEX];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Result();
        }

        int lo = 1;
        int hi = 1;

        array[0].val = lo;
        for (int i = 2; i <= MAX_INDEX; i++) {
            if (hi % 2 == 0)
                array[i - 1].b = true;
            else
                array[i - 1].b = false;
            array[i - 1].val = hi;
            hi = lo + hi;
            lo = hi - lo;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(i + 1 + ": " + array[i].val
                    + (array[i].b ? " *" : ""));
        }
    }

}
