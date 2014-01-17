package ch10.ex10_02;

public class Ex10_02 {

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
            switch (c) {
            case '\n':
                dst = dst.append("\\n");
                break;

            case '\t':
                dst = dst.append("\\t");
                break;

            case '\b':
                dst = dst.append("\\b");
                break;

            case '\r':
                dst = dst.append("\\r");
                break;

            case '\f':
                dst = dst.append("\\f");
                break;

            case '\\':
                dst = dst.append("\\\\");
                break;

            case '\'':
                dst = dst.append("\\'");
                break;

            case '\"':
                dst = dst.append("\\\"");
                break;

            default:
                dst = dst.append(c);
                break;
            }
        }

        return dst.toString();
    }

}
