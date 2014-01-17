package ch14.ex14_06;

public class TimerThread extends Observable implements Runnable {

    @Override
    public void run() {

        for (int i = 1;; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i + "秒経過");
            notifyObservers();

        }

    }

}
