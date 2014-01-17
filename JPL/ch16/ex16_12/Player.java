package ch16.ex16_12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public abstract class Player {

    public abstract void play(Game game);

    public void use(URL url) {

        if (url == null)
            return;

        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(url.getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        System.out.print("use " + url.getFile() + ": ");

        String line;
        try {
            while ((line = in.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
