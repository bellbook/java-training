package ch21.ex21_06;

import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

public class Concat {

    public static void main(String[] args) throws IOException {

        InputStream in; // 文字を読み込むべきストリーム
        if (args.length == 0) {
            in = System.in;
        } else {
            FileEnumeration files = new FileEnumeration(args);
            in = new SequenceInputStream(files);
        }

        int ch;
        while ((ch = in.read()) != -1)
            System.out.write(ch);
    }

}
