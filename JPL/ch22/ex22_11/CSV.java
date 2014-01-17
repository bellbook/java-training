package ch22.ex22_11;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    public static void main(String[] args) {

        try {
            List<String[]> list = readCSVTable(new FileReader(
                    "resources/ch22/csv1.txt"));

            for (String[] vals : list) {
                for (String val : vals)
                    System.out.print(val + " ");
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static final int CELLS = 4;

    public static List<String[]> readCSVTable(Reader source) throws IOException {
        StreamTokenizer in = new StreamTokenizer(source);
        List<String[]> vals = new ArrayList<String[]>();

        String[] cells = new String[CELLS];
        int i = 0;

        in.eolIsSignificant(true);
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            if (in.ttype == StreamTokenizer.TT_EOL) {
                vals.add(cells);
                cells = new String[CELLS];
                i = 0;
            } else if (in.ttype == StreamTokenizer.TT_NUMBER) {
                cells[i] = String.valueOf(in.nval);
                i++;
            }
        }

        return vals;
    }

}
