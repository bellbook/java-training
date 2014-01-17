package ch14.ex14_09;

public class Ex14_09 {

    public static void main(String[] args) {

        ThreadGroup root = new ThreadGroup("root");
        ThreadGroup group1 = new ThreadGroup(root, "group1");
        ThreadGroup group2 = new ThreadGroup(group1, "group2");

        new MyThread(root, "thread1", 2).start();
        new MyThread(root, "thread2", 4).start();
        new MyThread(group1, "thread3", 6).start();
        new MyThread(group2, "thread4", 8).start();

        ShowThread myThread = new ShowThread(root);
        myThread.start();
    }

}
