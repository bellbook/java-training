package ch21.ex21_02;

import java.io.File;
import java.util.Set;
import java.util.WeakHashMap;

public class DataHandler {

    private File lastFile;
    private WeakHashMap<byte[], Object> lastData = new WeakHashMap<byte[], Object>();

    byte[] readFile(File file) {

        byte[] data = null;

        if (file.equals(lastFile)) {
            Set<byte[]> set = lastData.keySet();
            for (byte[] s : set)
                data = s;
            if (data != null)
                return data;
        }

        data = readBytesFromFile(file);
        lastFile = file;
        lastData.clear();
        lastData.put(data, null);
        return data;
    }

    private byte[] readBytesFromFile(File file) {
        return null;
    }

}
