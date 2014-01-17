package ch22.ex22_10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex22_10 {

    public static void main(String[] args) {

        try {
            List<String> lines = readLines(new FileReader(
                    "resources/ch20/token.txt"));

            for (String line : lines) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readLines(Reader source) throws IOException {

        Scanner in = new Scanner(source);
        String COMMENT = "#.*\\r\\n";
        String DELIMITER = "\\p{javaWhitespace}+";

        List<String> lines = new ArrayList<String>();
        in.useDelimiter(COMMENT + "|" + DELIMITER);

        while (in.hasNext()) {
            String line = in.next();
            if (line != null) {
                lines.add(line);
            }
        }

        IOException ex = in.ioException();
        if (ex != null)
            throw ex;

        return lines;
    }

}
