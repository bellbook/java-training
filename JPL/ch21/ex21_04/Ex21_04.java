package ch21.ex21_04;

import java.util.LinkedList;
import java.util.List;

public class Ex21_04 {

    public static void main(String[] args) {

        List<String> list = new LinkedList<String>();

        list.add("0");
        list.add("123456789");
        list.add("01");
        list.add("23456789");
        list.add("012");
        list.add("3456789");
        list.add("0123");
        list.add("456789");
        list.add("01234");
        list.add("56789");

        ShortStrings shortStrings;
        shortStrings = new ShortStrings(list.listIterator(), 5);
        while (shortStrings.hasNext()) {
            System.out.println(shortStrings.next());
            System.out.println("nextIndex     : " + shortStrings.nextIndex());
            System.out.println("previousIndex : " + shortStrings.previousIndex());
        }

        shortStrings = new ShortStrings(list.listIterator(list.size()), 5);
        while (shortStrings.hasPrevious()) {
            System.out.println(shortStrings.previous());
            System.out.println("nextIndex     : " + shortStrings.nextIndex());
            System.out.println("previousIndex : " + shortStrings.previousIndex());
        }
    }

}
