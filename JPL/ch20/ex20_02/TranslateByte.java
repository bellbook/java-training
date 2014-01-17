package ch20.ex20_02;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class TranslateByte extends FilterReader {

    public static void main(String[] args) {

        StringReader str = new StringReader("abracadabra!");
        Reader reader = new TranslateByte(str, 'b', 'B');

        try {
            int c;
            while ((c = reader.read()) != -1)
                System.out.print((char) c);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private char from, to;

    public TranslateByte(Reader in, char from, char to) {
        super(in);
        this.from = from;
        this.to = to;
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : translate((char) c));
    }

    @Override
    public int read(char[] buf, int offset, int count) throws IOException {
        int nread = super.read(buf, offset, count);
        int last = offset + nread;
        for (int i = offset; i < last; i++)
            buf[i] = translate(buf[i]);
        return nread;
    }

    private char translate(char c) {
        return c == from ? to : c;
    }

}
