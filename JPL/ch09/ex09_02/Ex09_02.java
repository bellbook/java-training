package ch09.ex09_02;

public class Ex09_02 {

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
        for (int i = 0; i < Integer.SIZE; i++) {
            count += x & 1;
            x = x >> 1;
        }
        return count;
    }

}
