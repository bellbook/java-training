package ch21.ex21_01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex21_01 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        if (args.length != 1)
            throw new IllegalArgumentException("Usage: <filepath> ");

        Reader fileReader;
        try {
            fileReader = new FileReader(args[0]);
        } catch (FileNotFoundException e) {
            System.err.println(e);
            return;
        }

        List<String> list = new ArrayList<String>();

        LineReader lineReader = new LineReader(fileReader);
        try {
            String line;
            while ((line = lineReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Collections.sort(list, new StringComparator());

        for (String line : list) {
            System.out.println(line);
        }
    }

}
