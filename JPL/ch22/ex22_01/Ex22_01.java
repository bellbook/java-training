package ch22.ex22_01;

import java.util.Formatter;

public class Ex22_01 {

    public static void main(String[] args) {

        double[] data = { 1, 2.2, 3.33, 44.4, 55.55, 6.6666, 77777 };

        format(data, 5);
    }

    public static void format(double[] data, int column) {

        int length = 80;
        int max = length / 10; // 1行に表示できる最大の数

        Formatter formatter = new Formatter(System.out);

        int line = data.length / column + 1;
        int index = 0;
        for (int y = 0; y < line; y++) {
            for (int x = 0; x < column; x++) {
                index = x + y * column;
                if (x >= max)
                    continue;
                if (index >= data.length)
                    continue;
                formatter.format("%1$.3e ", data[index]);
            }
            System.out.println();
        }
    }

}
