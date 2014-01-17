package ch13.ex13_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Ex13_04 {

    public static void main(String[] args) {

        String str = "Boolean true\nCharacter c\nInteger 1\n";

        List<Object> list = readTypeValue(str);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<Object> readTypeValue(String src) {

        String[] strs = delimitedString(src, '\n');

        List<Object> list = new ArrayList<Object>();

        for (int i = 0; i < strs.length; i++) {

            System.out.println(strs[i]);
            Scanner scanner = new Scanner(strs[i]);
            scanner.findInLine("(\\w+) (\\w+)");
            MatchResult result = scanner.match();

            list.add(toObject(result.group(1), result.group(2)));
        }

        return list;
    }

    public static Object toObject(String type, String value) {

        if (type.equals("Boolean")) {
            return new Boolean(Boolean.parseBoolean(value));
        } else if (type.equals("Character")) {
            return new Character(value.charAt(0));
        } else if (type.equals("Integer")) {
            return new Integer(Integer.parseInt(value));
        } else {
            return null;
        }

    }

    public static String[] delimitedString(String from, char end) {

        List<String> list = new ArrayList<String>();

        int startPos = 0;
        int endPos = 0;

        while (endPos < from.length()) {

            endPos = from.indexOf(end, startPos);
            if (endPos == -1) {
                break;
            } else {
                list.add(from.substring(startPos, endPos));
                startPos = endPos + 1;
            }
        }

        String[] to = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            to[i] = list.get(i);
        }
        return to;
    }

}
