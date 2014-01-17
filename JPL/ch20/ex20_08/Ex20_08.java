package ch20.ex20_08;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex20_08 {

    private static final String LF = System.getProperty("line.separator");

    public static void main(String[] args) {

        try {
            createTable("resources/ch20/entry.txt", "resources/ch20/table.txt");
            showEntry("resources/ch20/entry.txt", "resources/ch20/table.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String entryFileName, String tableFileName)
            throws IOException {

        List<Long> table = new ArrayList<Long>();

        RandomAccessFile raf = new RandomAccessFile(entryFileName, "r");
        try {
            do {
                if (raf.readByte() == '%' && raf.readByte() == '%')
                    table.add(raf.getFilePointer());

            } while (raf.readLine() != null);
        } catch (EOFException e) {
        }
        raf.close();

        Writer writer = new FileWriter(tableFileName);
        for (long num : table)
            writer.write(num + LF);
        writer.close();
    }

    public static void showEntry(String entryFileName, String tableFileName)
            throws IOException {

        List<Long> table = new ArrayList<Long>();

        BufferedReader reader = new BufferedReader(new FileReader(tableFileName));
        String line;
        while((line = reader.readLine()) != null)
            table.add(Long.valueOf(line));
        reader.close();

        RandomAccessFile raf = new RandomAccessFile(entryFileName, "r");
        Collections.shuffle(table);
        for (Long num : table) {
            raf.seek(num);
            String entry = raf.readLine();
            if (entry != null)
                System.out.println(entry);
        }
        raf.close();
    }

}
