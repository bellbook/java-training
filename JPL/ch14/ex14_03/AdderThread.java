package ch14.ex14_03;

public class AdderThread extends Thread {

    private Adder adder;

    public AdderThread(String name, Adder adder) {
        super(name);
        this.adder = adder;
    }

    public void run() {

        for (int i = 0; i < 5; i++) {
            adder.add(Thread.currentThread().getName(), 1);
        }
    }

}
