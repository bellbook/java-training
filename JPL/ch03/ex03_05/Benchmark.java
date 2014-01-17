package ch03.ex03_05;

public abstract class Benchmark {

    abstract void benchmark();

    public final long repeat(int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++)
            benchmark();
        return (System.currentTimeMillis() - start);
    }

}
