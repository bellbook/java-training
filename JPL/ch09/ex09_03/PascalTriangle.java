package ch09.ex09_03;

public class PascalTriangle {

    // より簡潔にはできない

    public static void main(String[] args) {
        PascalTriangle p = new PascalTriangle();
        p.calc();
        p.show();
    }

    private static final int DEPTH = 12;

    private int[][] array = new int[DEPTH][];

    public void calc() {

        for (int i = 0; i < DEPTH; i++) {
            array[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                if (i >= 1 && j >= 1 && i > j) {
                    array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
                } else {
                    array[i][j] = 1;
                }
            }
        }
    }

    public void show() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

}
