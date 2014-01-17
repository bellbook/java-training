package ch14.ex14_09;

public class MyThread extends Thread {

    private int seconds;

    public MyThread(ThreadGroup group, String name, int seconds) {
        super(group, name);
        this.seconds = seconds;
    }

    public void run() {
        synchronized (this) {
            try {
                wait(1000 * seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
