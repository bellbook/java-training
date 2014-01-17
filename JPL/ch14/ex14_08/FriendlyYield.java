package ch14.ex14_08;

// デッドロックの発生頻度が2回に1回に変更する。

public class FriendlyYield {
    private FriendlyYield partner;
    private String name;

    public FriendlyYield(String name) {
        this.name = name;
    }

    public synchronized void hug() {
        System.out.println(Thread.currentThread().getName() + " in " + name
                + ".hug() trying to invoke " + partner.name + ".hugBack()");
        partner.hugBack();
    }

    private synchronized void hugBack() {
        System.out.println(Thread.currentThread().getName() + " in " + name
                + ".hugBack()");
    }

    public void becomeFriend(FriendlyYield partner) {
        this.partner = partner;
    }

    public static void main(String[] args) {
        final FriendlyYield jareth = new FriendlyYield("jareth");
        final FriendlyYield cory = new FriendlyYield("cory");

        jareth.becomeFriend(cory);
        cory.becomeFriend(jareth);

        new Thread(new Runnable() {

            public void run() {
                jareth.hug();
                Thread.yield();
            }
        }, "Thread1").start();

        new Thread(new Runnable() {

            public void run() {
                cory.hug();
                Thread.yield();
            }
        }, "Thread2").start();
    }

}
