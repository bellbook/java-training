package console.swing;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class JTextAreaOutputStream extends OutputStream {

    private JTextArea textArea;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    public JTextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public void flush() {
        textArea.append(out.toString());
        out.reset();
    }

}
