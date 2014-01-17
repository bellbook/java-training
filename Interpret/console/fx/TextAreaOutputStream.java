package console.fx;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javafx.scene.control.TextArea;

public class TextAreaOutputStream extends OutputStream {

    private TextArea textArea;
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    public TextAreaOutputStream(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }

    @Override
    public void flush() {
        textArea.appendText(out.toString());
        out.reset();
    }

}
