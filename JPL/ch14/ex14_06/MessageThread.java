package ch14.ex14_06;

public class MessageThread implements Runnable, Observer {

    private int count;

    private int seconds;
    private String message;

    public MessageThread(int seconds, String message) {
        this.seconds = seconds;
        this.message = message;
    }

    @Override
    public void run() {

        for (;;) {
            try {
                show();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void update() {
        count++;
        notifyAll();
    }

    public synchronized void show() throws InterruptedException {

        while (count != seconds) {
            wait();
        }

        System.out.println(message);
        count = 0;
    }

}
