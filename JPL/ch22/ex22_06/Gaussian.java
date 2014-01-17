package ch22.ex22_06;

import java.util.Random;

public class Gaussian {

    public static void main(String[] args) {
        Gaussian.showGaussian(2000);
    }

    private static final double STEP = 0.1; // 0.1
    private static final double MAX = 3; // -3.0 ~ 3.0
    private static final double INVERSE_STEP = (int) (1 / STEP);
    private static final int LENGTH = (int) (MAX / STEP);

    private static Random rand = new Random(System.currentTimeMillis());

    public static void showGaussian(int sample) {

        int[] histogram = new int[LENGTH * 2];

        for (int i = 0; i < sample; i++) {

            double norm = rand.nextGaussian() * INVERSE_STEP;
            if (norm < 0.0 && norm > -1.0)
                continue;

            int normInt = (int) norm;
            if (normInt < LENGTH && normInt >= LENGTH * -1)
                histogram[normInt + LENGTH]++;
        }

        for (int i = 0; i < histogram.length; i++) {

            double x = (i - LENGTH) * 0.1;

            if (x < 0)
                System.out.printf("%.1f ", x);
            else
                System.out.printf(" %.1f ", x);

            for (int j = 0; j < histogram[i]; j++)
                System.out.print("*");
            System.out.println();
        }
    }

}
