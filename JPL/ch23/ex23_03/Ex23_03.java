package ch23.ex23_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Ex23_03 {

    public static void main(String[] args) {
        try {
            userProg("cmd", "Copyright");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Process userProg(String cmd, String exitWord) throws IOException {
        Process proc = Runtime.getRuntime().exec(cmd);
        plugTogether(proc.getInputStream(), System.out, proc, exitWord);
        return proc;
    }

    private static void plugTogether(final InputStream in, final PrintStream out,
            final Process proc, final String exitWord) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                try {
                    int num = 1;
                    String line;
                    while ((line = r.readLine()) != null) {
                        if (line.contains(exitWord))
                            proc.destroy();
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
