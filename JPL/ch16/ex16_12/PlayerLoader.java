package ch16.ex16_12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PlayerLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            byte[] buf = bytesForClass(name);
            return defineClass(name, buf, 0, buf.length);

        } catch (IOException e) {
            throw new ClassNotFoundException(e.toString());
        }
    }

    protected byte[] bytesForClass(String name) throws IOException,
            ClassNotFoundException {

        FileInputStream in = null;

        try {
            in = streamFor(name + ".class");
            int length = in.available();
            if (length == 0)
                throw new ClassNotFoundException(name);
            byte[] buf = new byte[length];
            in.read(buf);
            return buf;
        } finally {
            if (in != null)
                in.close();
        }
    }

    protected FileInputStream streamFor(String className) {

        try {
            return new FileInputStream(className);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected URL findResource(String name) {
        File f = fileFor(name);
        if (!f.exists())
            return null;
        try {
            return f.toURI().toURL();
        } catch (MalformedURLException e) {
            return null; // 起きるはずがない
        }
    }

    protected File fileFor(String resourceName) {
        return new File("resources/ch16/" + resourceName);
    }

}
