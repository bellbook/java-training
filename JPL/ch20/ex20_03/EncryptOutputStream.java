package ch20.ex20_03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream {

    public EncryptOutputStream(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        b = encrypt((byte) b);
        super.write(b);
    }

    private byte encrypt(byte b) {
        return (byte) (b ^ Key.VALUE);
    }

}
