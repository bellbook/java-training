package ch14.ex14_02;

public class PrintServer implements Runnable {

    private final PrintQue requests = new PrintQue();

    private Thread thread = new Thread(this);

    public PrintServer() {
        thread.start();
    }

    public void print(PrintJob job) {
        requests.add(job);
    }

    @Override
    public void run() {

        if (Thread.currentThread() != thread)
            return;

        for (int i = 0; i < 1; i++) {
            realPrint(requests.remove());
        }
    }

    private void realPrint(PrintJob job) {

    }

    class PrintQue {

        public void add(PrintJob job) {

        }

        public PrintJob remove() {
            System.out.println("remove");
            return null;
        }

    }

    class PrintJob {

    }

}
