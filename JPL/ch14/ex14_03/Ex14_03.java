package ch14.ex14_03;

public class Ex14_03 {

    public static void main(String[] args) {

        Adder adder = new Adder();

        AdderThread thread1 = new AdderThread("thread1", adder);
        AdderThread thread2 = new AdderThread("thread2", adder);
        AdderThread thread3 = new AdderThread("thread3", adder);

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
