package ch21.ex21_06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class FileEnumeration implements Enumeration<InputStream> {

    private String[] args;
    private int id = -1;

    public FileEnumeration(String[] args) {
        this.args = args;
    }

    @Override
    public boolean hasMoreElements() {
        return id + 1 < args.length;
    }

    @Override
    public InputStream nextElement() {

        if (hasMoreElements() == false)
            throw new NoSuchElementException();

        id++;

        try {
            return new FileInputStream(args[id]);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

}
