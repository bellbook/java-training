package ch10.ex10_04;

public class DoWhile {

    // do-whileで書き直したりしない。
    // do-whileを利用するのは文を1度は必ず実行してほしいときであり、
    // そういうときのみ用いるのが普通である。

    public static void main(String[] args) {

        System.out.println("00000000 = "
                + bitCount(Integer.parseInt("00000000", 2)));
        System.out.println("00000001 = "
                + bitCount(Integer.parseInt("00000001", 2)));
        System.out.println("01010101 = "
                + bitCount(Integer.parseInt("01010101", 2)));
        System.out.println("10111101 = "
                + bitCount(Integer.parseInt("10111101", 2)));
        System.out.println("11111111 = "
                + bitCount(Integer.parseInt("11111111", 2)));
    }

    public static int bitCount(int x) {

        int count = 0;

        int i = 0;
        do {
            count += x & 1;
            x = x >> 1;
            i++;
        } while (i < Integer.SIZE);

        return count;
    }

}
