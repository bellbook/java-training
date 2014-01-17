package ch22.ex22_14;

import java.util.StringTokenizer;

public class Ex22_14 {

    public static void main(String[] args) {

        String str = "1.01 2.02 3.3";

        System.out.println(sumDouble(str));
    }

    public static double sumDouble(String str) {

        double sum = 0.0;

        StringTokenizer tokens = new StringTokenizer(str, " ");
        while (tokens.hasMoreElements()) {
            sum += Double.parseDouble(tokens.nextToken());
        }
        return sum;
    }

}
