package ch10.ex10_05;

public class EX10_05 {

    public static void main(String[] args) {

        show('D', 'K');
        show('a', 'x');
        show('D', 'z');
        show('i', 'I');
    }

    public static void show(Character c1, Character c2) {

        if (c1 < 'A' && c1 > 'Z' && c1 < 'a' && c1 > 'z') {
            System.out.println("c1 is [A-Z] or [a-z]");
            return;
        }

        if (c2 < 'A' && c2 > 'Z' && c2 < 'a' && c2 > 'z') {
            System.out.println("c2 is [A-Z] or [a-z]");
            return;
        }

        if (Character.isUpperCase(c1) && Character.isLowerCase(c2)) {

            for (Character c = c1; c <= 'Z'; c++) {
                System.out.print(c);
            }
            for (Character c = 'a'; c <= c2; c++) {
                System.out.print(c);
            }
            System.out.println();

        } else {

            for (Character c = c1; c <= c2; c++) {
                System.out.print(c);
            }
            System.out.println();

        }
    }

}
