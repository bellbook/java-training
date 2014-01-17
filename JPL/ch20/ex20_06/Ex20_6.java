package ch20.ex20_06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Iterator;

public class Ex20_6 {

    public static void main(String[] args) {

        try {
            Attributed attrs = readAttrs(new FileReader(
                    "resources/ch20/token.txt"));

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

        StreamTokenizer in = new StreamTokenizer(source);
        AttributedImpl attrs = new AttributedImpl();
        Attr attr = null;
        char op = 0;
        in.commentChar('#');
        in.ordinaryChar('/');
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            if (in.ttype == StreamTokenizer.TT_WORD) {
                if (attr != null) {
                    attr.setValue(in.sval);
                    attr = null;
                } else {
                    attr = new Attr(in.sval);
                }
            } else if (in.ttype == '=') {
                if (attr == null)
                    throw new IOException("misplaced '='");
                op = '=';
            } else if (in.ttype == '+') {
                if (attr == null)
                    throw new IOException("misplaced '+'");
                op = '+';
            } else if (in.ttype == '-') {
                if (attr == null)
                    throw new IOException("misplaced '-'");
                op = '-';
            } else {
                if (attr == null)
                    throw new IOException("bad Attr name");
                if (op == '=') {
                    attr.setValue(new Double(in.nval));
                    attrs.add(attr);
                } else if (op == '+') {
                    Attr saved = attrs.find(attr.getName());
                    if (saved != null)
                        attr.setValue((Double) saved.getValue()
                                + new Double(in.nval));
                    else
                        attr.setValue(new Double(in.nval));
                    attrs.add(attr);
                } else if (op == '-') {
                    Attr saved = attrs.find(attr.getName());
                    if (saved != null)
                        attr.setValue((Double) saved.getValue()
                                - new Double(in.nval));
                    else
                        attr.setValue(new Double(in.nval));
                    attrs.add(attr);
                }
                attr = null;
            }
        }
        return attrs;
    }

}
