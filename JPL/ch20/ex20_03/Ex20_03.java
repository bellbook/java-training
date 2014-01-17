package ch20.ex20_03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex20_03 {

    public static void main(String[] args) throws IOException {

        String original = "abracadabra!";
        System.out.println("original: " + original);

        ByteArrayInputStream in;
        ByteArrayOutputStream out;

        in = new ByteArrayInputStream(original.getBytes());
        out = new ByteArrayOutputStream();

        FilterOutputStream fout = new EncryptOutputStream(out);

        transfer(in, fout);

        String encrypt = out.toString();
        System.out.println("encrypt: " + encrypt);

        in = new ByteArrayInputStream(encrypt.getBytes());
        out = new ByteArrayOutputStream();

        FilterInputStream fin = new DecryptInputStream(in);

        transfer(fin, out);

        String decrypt = out.toString();
        System.out.println("decrypt: " + decrypt);
    }

    public static void transfer(InputStream in, OutputStream out)
            throws IOException {

        if (in instanceof BufferedInputStream == false
                && in instanceof ByteArrayInputStream == false)
            in = new BufferedInputStream(in);

        if (out instanceof BufferedOutputStream == false
                && out instanceof ByteArrayOutputStream == false)
            out = new BufferedOutputStream(out);

        byte[] buf = new byte[1024];
        int len;
        try {
            while ((len = in.read(buf)) != -1)
                out.write(buf, 0, len);
            out.flush();
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }

}
