package ch20.ex20_01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {

    public static void main(String[] args) {

        String str = "abracadabra!";

        InputStream input = new ByteArrayInputStream(str.getBytes());
        OutputStream output = System.out;

        try {
            translate(input, output, 'b', 'B');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void translate(InputStream input, OutputStream output,
            char from, char to) throws IOException {

        InputStream in = new BufferedInputStream(input);
        OutputStream out = new BufferedOutputStream(output);
        try {
            int b;
            while ((b = in.read()) != -1)
                out.write(b == from ? to : b);
            out.flush();
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }

}
