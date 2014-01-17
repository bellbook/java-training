package ch10.ex10_01;

public class Ex10_01 {

    public static void main(String[] args) {

        String before = "\n\t\b\r\f\\\'\"";
        String after = "";

        after = replace(before);

        System.out.println("before: " + before);
        System.out.println();
        System.out.println("after: " + after);
    }

    public static String replace(String src) {

        StringBuilder dst = new StringBuilder();

        for (int i = 0; i < src.length(); i++) {

            char c = src.charAt(i);
            if (c == '\n') {
                dst = dst.append("\\n");
            } else if (c == '\t') {
                dst = dst.append("\\t");
            } else if (c == '\b') {
                dst = dst.append("\\b");
            } else if (c == '\r') {
                dst = dst.append("\\r");
            } else if (c == '\f') {
                dst = dst.append("\\f");
            } else if (c == '\\') {
                dst = dst.append("\\\\");
            } else if (c == '\'') {
                dst = dst.append("\\'");
            } else if (c == '\"') {
                dst = dst.append("\\\"");
            } else {
                dst = dst.append(c);
            }
        }

        return dst.toString();
    }

}
