package ch07.ex07_02;

public class Ex07_02 {

    static char c;
    static byte b;
    static short s;
    static int i;
    static long l;
    static float f;
    static double d;

    public static void main(String[] args) {

        // 代入可能
        System.out.println(i = Character.MAX_VALUE);
        System.out.println(i = Byte.MAX_VALUE);
        System.out.println(i = Short.MAX_VALUE);

        System.out.println(l = Character.MAX_VALUE);
        System.out.println(l = Byte.MAX_VALUE);
        System.out.println(l = Short.MAX_VALUE);
        System.out.println(l = Integer.MAX_VALUE);

        System.out.println(f = Character.MAX_VALUE);
        System.out.println(f = Byte.MAX_VALUE);
        System.out.println(f = Short.MAX_VALUE);
        System.out.println(f = Integer.MAX_VALUE);
        System.out.println(f = Long.MAX_VALUE);

        System.out.println(d = Character.MAX_VALUE);
        System.out.println(d = Byte.MAX_VALUE);
        System.out.println(d = Short.MAX_VALUE);
        System.out.println(d = Integer.MAX_VALUE);
        System.out.println(d = Long.MAX_VALUE);
        System.out.println(d = Float.MAX_VALUE);
    }

}
