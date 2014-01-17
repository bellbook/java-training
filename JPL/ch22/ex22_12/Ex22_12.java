package ch22.ex22_12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Ex22_12 {

    public static void main(String[] args) {

        try {
            Attributed attrs = readAttrs(new FileReader(
                    "resources/ch22/token.txt"));

            for (Iterator<Attr> i = attrs.attrs(); i.hasNext();) {
                System.out.println(i.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Attributed readAttrs(Reader source) throws IOException {

        Scanner in = new Scanner(source);
        AttributedImpl attrs = new AttributedImpl();
        Attr attr = null;

        String exp = "(.*?)=(.*)$";
        Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
        while (in.hasNextLine()) {
            String line = in.findInLine(pat);
            if (line != null) {
                MatchResult match = in.match();
                String name = match.group(1).trim();
                String value = match.group(2).trim();
                attr = new Attr(name, value);
                attrs.add(attr);
                in.nextLine();
            } else {
                throw new IOException("input format error");
            }
        }

        IOException ex = in.ioException();
        if (ex != null)
            throw ex;

        return attrs;
    }

}
