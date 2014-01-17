package ch14.ex14_04;

public class AdderThread extends Thread {

    public AdderThread(String name) {
        super(name);
    }

    public void run() {

        for (int i = 0; i < 5; i++) {
            Adder.add(Thread.currentThread().getName(), 1);
        }
    }

}
