package ch22.ex22_05;

public class Counter {

    private static final int MAX = 6;
    private static final int MIN = 1;

    private int step;
    private int times;
    private int number = MIN;

    public Counter(int step) {
        this.step = step;
    }

    public int next() {

        if (times >= step) {
            times = 0;
            if (number >= MAX)
                number = MIN;
            else
                number++;
        }
        times++;

        return number;
    }

}
