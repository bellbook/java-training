package ch20.ex20_10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex20_10 {

    public static void main(String[] args) {

        try {
            WordCounter wc = new WordCounter(new FileReader(
                    "resources/test.txt"));
            wc.show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
