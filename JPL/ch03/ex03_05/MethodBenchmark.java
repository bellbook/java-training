package ch03.ex03_05;

public class MethodBenchmark extends Benchmark {

    private int loop;

    void benchmark() {
        for (int i = 0; i < loop; i++)
            ;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);
        int loop = Integer.parseInt(args[1]);

        MethodBenchmark benchmark = new MethodBenchmark();
        benchmark.setLoop(loop);
        long time = benchmark.repeat(count);
        System.out.println(loop + " loop");
        System.out.println(count + " methods in " + time + " milliseconds");
    }

}