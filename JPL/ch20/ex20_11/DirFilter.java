package ch20.ex20_11;

import java.io.File;
import java.io.FilenameFilter;

public class DirFilter implements FilenameFilter {

    public static void main(String[] args) {
        File dir = new File("resources");
        String[] files = dir.list(new DirFilter("txt"));
        System.out.println(files.length + " file(s):");
        for (String file : files)
            System.out.println("\t" + file);
    }

    private String suffix;

    public DirFilter(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix) && new File(dir, name).isFile();
    }

}
