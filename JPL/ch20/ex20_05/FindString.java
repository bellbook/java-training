package ch20.ex20_05;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class FindString {

    public static void main(String[] args) throws IOException {

        if (args.length != 2)
            throw new IllegalArgumentException("Usage: <word> <filepath> ");

        String match = args[0];
        System.out.println("Search Word: " + match);
        System.out.println();

        FileReader fileIn = new FileReader(args[1]);
        LineNumberReader in = new LineNumberReader(fileIn);

        String line;
        while ((line = in.readLine()) != null) {
            if (line.indexOf(match) != -1)
                System.out.println("line" + in.getLineNumber() + ": " + line);
        }
    }

}
