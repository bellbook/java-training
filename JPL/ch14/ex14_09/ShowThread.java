package ch14.ex14_09;

public class ShowThread extends Thread {

    private ThreadGroup group;

    public ShowThread(ThreadGroup group) {
        this.group = group;
    }

    public void run() {
        show();
    }

    public synchronized void show() {

        for (;;) {
            showGroup(group, 1);
            System.out.println("----------");

            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void showGroup(ThreadGroup group, int layer) {

        int tmp = layer;

        ThreadGroup[] groupList = new ThreadGroup[group.activeGroupCount()];

        int groupNum = group.enumerate(groupList, false);
        for (int i = 0; i < groupNum; i++) {
            System.out.println(layer + "階層: " + groupList[i].getName());
            showGroup(groupList[i], tmp += 1);
        }

        showThread(group, layer);
    }

    public void showThread(ThreadGroup group, int layer) {

        Thread[] threadList = new Thread[group.activeCount()];

        int threadNum = group.enumerate(threadList, false);
        for (int i = 0; i < threadNum; i++) {
            System.out.println(layer + "階層: " + threadList[i].getName()
                    + " in " + group.getName());
        }

    }

}
