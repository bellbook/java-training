package ch17.ex17_01;

import java.awt.Frame;

public class Ex17_01 {

    public static void main(String[] args) {

        System.out.println("----- Free Memory Size -----");

        Runtime rt = Runtime.getRuntime();
        System.out.println("START: " + rt.freeMemory() / 1000 / 1000 + " [MB]");

        Frame[] f = new Frame[10000];
        for (int i = 0; i < f.length; i++)
            f[i] = new Frame();
        System.out.println("CREATE OBJECTS: " + rt.freeMemory() / 1000 / 1000 + " [MB]");

        for (int i = 0; i < f.length; i++)
            f[i] = null;
        rt.gc();
        System.out.println("GARBAGE COLLECTION: " + rt.freeMemory() / 1000 / 1000 + " [MB]");
    }

}
