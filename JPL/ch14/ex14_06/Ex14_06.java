package ch14.ex14_06;

public class Ex14_06 {

    public static void main(String[] args) {

        MessageThread msgThread1 = new MessageThread(15, "Fifteen!");
        MessageThread msgThread2 = new MessageThread(7, "Seven!");

        TimerThread timerThread = new TimerThread();
        timerThread.addObserver(msgThread1);
        timerThread.addObserver(msgThread2);

        new Thread(timerThread).start();
        new Thread(msgThread1).start();
        new Thread(msgThread2).start();

    }

}
