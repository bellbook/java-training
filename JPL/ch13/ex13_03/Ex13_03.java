package ch13.ex13_03;

import java.util.ArrayList;
import java.util.List;

public class Ex13_03 {

    public static void main(String[] args) {

        String[] strs = delimitedString("<Hello> <World> <!> ><", '<', '>');

        for (String str : strs) {
            System.out.println(str);
        }
    }

    public static String[] delimitedString(String from, char start, char end) {

        List<String> list = new ArrayList<String>();

        int startPos = 0;
        int endPos = 0;

        while (endPos < from.length()) {

            startPos = from.indexOf(start, endPos);
            endPos = from.indexOf(end, startPos);
            if (startPos == -1) {
                break;
            } else if (endPos == -1) {
                break;
            } else if (startPos > endPos) {
                break;
            } else {
                list.add(from.substring(startPos, endPos + 1));
            }
        }

        String[] to = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            to[i] = list.get(i);
        }
        return to;
    }

}
