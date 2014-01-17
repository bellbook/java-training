package console;

import java.util.Observable;

public abstract class Console extends Observable {

    protected int width;
    protected int height;

    public Console(int width, int height) {
        this.width  = width;
        this.height = height;
    }

    public abstract void show();

}
