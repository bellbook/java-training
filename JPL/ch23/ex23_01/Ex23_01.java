package ch23.ex23_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex23_01 {

    public static void main(String[] args) {
        try {
            userProg("cmd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Process userProg(String cmd) throws IOException {
        Process proc = Runtime.getRuntime().exec(cmd);
        plugTogether(System.in, proc.getOutputStream());
        plugTogether(System.out, proc.getInputStream());
        plugTogether(System.err, proc.getErrorStream());
        return proc;
    }

    private static void plugTogether(final InputStream in, final OutputStream out) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    int c;
                    while ((c = in.read()) != -1)
                        out.write(c);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }

    private static void plugTogether(OutputStream out, InputStream in) {
        plugTogether(in, out);
    }

}
