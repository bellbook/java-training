package ch13.ex13_06;

public class Ex13_06 {

    public static void main(String[] args) {

        String str = "1543729";

        System.out.println(delimit(str, 2, " "));
        System.out.println(delimit(str, 3, ","));
        System.out.println(delimit(str, 4, "."));
    }

    public static String delimit(String src, int digit, String delimiter) {

        StringBuilder dst = new StringBuilder(src);

        for (int i = dst.length() - digit; i >= 0; i -= digit)
            dst.insert(i, delimiter);

        return dst.toString();
    }

}
