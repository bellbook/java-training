package ch14.ex14_04;

public class Ex14_04 {

    public static void main(String[] args) {

        AdderThread thread1 = new AdderThread("thread1");
        AdderThread thread2 = new AdderThread("thread2");
        AdderThread thread3 = new AdderThread("thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
