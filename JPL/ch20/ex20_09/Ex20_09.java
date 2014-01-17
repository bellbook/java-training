package ch20.ex20_09;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class Ex20_09 {

    public static void main(String[] args) {

        try {
            show(new File[] { new File("resources"),
                    new File("resources/test.txt") });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show(File[] files) throws IOException {

        for (File file : files) {
            show(file);
            System.out.println();
        }
    }

    public static void show(File file) throws IOException {

        System.out.println("----- File Info -----");

        System.out.println("Name: " + file.getName());

        System.out.print("Type: ");
        if (file.isHidden())
            System.out.print("Hidden ");
        if (file.isDirectory())
            System.out.println("Directory");
        else if (file.isFile())
            System.out.println("File");
        else
            System.out.println("Special File");

        System.out.println("Path: " + file.getCanonicalPath());

        System.out.print("Permission: ");
        if (file.canRead())
            System.out.print("r");
        if (file.canWrite())
            System.out.print("w");

        System.out.println();

        System.out.println("Last Modified: "
                + new Timestamp(file.lastModified()));

        System.out.println("File Size: " + file.length() + "[byte]");

        if (file.isDirectory()) {
            System.out.println();
            for (File f : file.listFiles()) {
                System.out.print(" ");
                System.out.print(new Timestamp(f.lastModified()));
                System.out.printf("\t");
                if (f.isDirectory())
                    System.out.print("<DIR>");
                else
                    System.out.print("     ");
                System.out.printf("\t");
                if (f.isFile())
                    System.out.print(f.length());
                System.out.printf("\t");
                System.out.println(f.getName());
            }
        }
    }

}
