package ch13.ex13_01;

public class Ex13_01 {

    public static void main(String[] args) {

        final String str = "apple orange";
        Character c;

        c = 'a';
        System.out.println(c + " in \"" + str + "\": " + count(str, c));

        c = ' ';
        System.out.println(c + " in \"" + str + "\": " + count(str, c));
    }

    public static int count(String str, Character ch) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

}
