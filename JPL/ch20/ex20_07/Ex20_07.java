package ch20.ex20_07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex20_07 {

    public static void main(String[] args) {

        OutputStream out = null;
        try {
            out = new FileOutputStream("resources/temp.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Attr outAttr = new Attr("apple", 1);
        try {
            outAttr.writeData(new DataOutputStream(out));
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStream in = null;
        try {
            in = new FileInputStream("resources/temp.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Attr inAttr = new Attr(new DataInputStream(in));
            System.out.println(inAttr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
