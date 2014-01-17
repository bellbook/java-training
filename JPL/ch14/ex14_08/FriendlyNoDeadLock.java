package ch14.ex14_08;

// 5回に1回デッドロックが発生する。

public class FriendlyNoDeadLock {
    private FriendlyNoDeadLock partner;
    private String name;

    public FriendlyNoDeadLock(String name) {
        this.name = name;
    }

    public void hug() {
        synchronized (FriendlyNoDeadLock.class) {
            System.out.println(Thread.currentThread().getName() + " in " + name
                    + ".hug() trying to invoke " + partner.name + ".hugBack()");
            partner.hugBack();
        }
    }

    private void hugBack() {
        synchronized (FriendlyNoDeadLock.class) {
            System.out.println(Thread.currentThread().getName() + " in " + name
                    + ".hugBack()");
        }
    }

    public void becomeFriend(FriendlyNoDeadLock partner) {
        this.partner = partner;
    }

    public static void main(String[] args) {
        final FriendlyNoDeadLock jareth = new FriendlyNoDeadLock("jareth");
        final FriendlyNoDeadLock cory = new FriendlyNoDeadLock("cory");

        jareth.becomeFriend(cory);
        cory.becomeFriend(jareth);

        new Thread(new Runnable() {

            public void run() {
                jareth.hug();
            }
        }, "Thread1").start();

        new Thread(new Runnable() {

            public void run() {
                cory.hug();
            }
        }, "Thread2").start();
    }

}
