package ch13.ex13_02;

public class Ex13_02 {

    public static void main(String[] args) {

        final String str = "abcdefabcaabbccdefabc";
        String s;

        s = "abc";
        System.out.println(s + " in \"" + str + "\": " + count(str, s));

        s = "def";
        System.out.println(s + " in \"" + str + "\": " + count(str, s));

        s = "zzz";
        System.out.println(s + " in \"" + str + "\": " + count(str, s));
    }

    public static int count(String str, String s) {

        int count = 0;
        int start = 0;

        for (;;) {
            start = str.indexOf(s, start);
            if (start == -1) {
                break;
            }
            start += s.length();
            count++;
        }
        return count;
    }
}
