package ch20.ex20_03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream {

    protected DecryptInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int b = super.read();
        return (b == -1 ? b : decrypt((byte) b));
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int nread = super.read(b, off, len);
        int last = off + nread;
        for (int i = off; i < last; i++)
            b[i] = decrypt(b[i]);
        return nread;
    }

    private byte decrypt(byte b) {
        return (byte) (b ^ Key.VALUE);
    }

}
