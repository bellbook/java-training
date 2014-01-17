package ch23.ex23_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Ex23_02 {

    public static void main(String[] args) {
        try {
            userProg("cmd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Process userProg(String cmd) throws IOException {
        Process proc = Runtime.getRuntime().exec(cmd);
        plugTogether(proc.getInputStream(), System.out);
        return proc;
    }

    private static void plugTogether(final InputStream in, final PrintStream out) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                try {
                    int num = 1;
                    String line;
                    while ((line = r.readLine()) != null) {
                        out.println(num + ": " + line);
                        num++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        thread.start();
    }

}
