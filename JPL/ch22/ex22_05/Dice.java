package ch22.ex22_05;

import java.util.Random;

public class Dice {

    public static final int FACE = 6;

    private Random rand = new Random();

    public int roll() {
        return rand.nextInt(FACE) + 1;
    }

}
