package console.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutFocusTraversalPolicy;

import console.Console;
import console.swing.JTextAreaOutputStream;

public class SwingConsole extends Console {

    private JFrame frame = new JFrame("Console");
    private JTextArea textArea = new JTextArea();

    private ArrayList<String> textList = new ArrayList<String>();
    private int textIndex;

    private String text;

    {
        JTextAreaOutputStream stream = new JTextAreaOutputStream(textArea);
        System.setOut(new PrintStream(stream, true));
    }

    public SwingConsole() {
        this(600, 400);
    }

    public SwingConsole(int width, int height) {
        super(width, height);
        layout();
    }

    @Override
    public void show() {
        frame.setVisible(true);
    }

    @SuppressWarnings("serial")
    private void layout() {

//        com.sun.awt.AWTUtilities.setWindowOpacity(frame, .85f);

        textArea.setEditable(false);
        textArea.setMargin(new Insets(0, 10, 0, 0));
        textArea.setForeground(Color.GREEN);
        textArea.setBackground(Color.BLACK);
        textArea.setSelectedTextColor(Color.WHITE);
        textArea.setSelectionColor(new Color(55, 155, 255));
        textArea.setCaretColor(Color.GREEN);
        textArea.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(width, height));
        scrollPane.setViewportView(textArea);

        final JTextField textField = new JTextField();
        textField.setMargin(new Insets(0, 10, 0, 0));
        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                switch (e.getKeyCode()) {

                case KeyEvent.VK_ENTER:
                    text = textField.getText();

                    if (text.trim().length() == 0)
                        return;

                    textList.add(text);
                    textIndex = textList.size();
                    textField.setText("");

                    textArea.setCaretPosition(textArea.getText().length());

                    setChanged();
                    notifyObservers(text);
                    break;

                case KeyEvent.VK_UP:
                    if (textIndex <= 0)
                        return;

                    textIndex--;

                    text = textList.get(textIndex);
                    textField.setText(text);
                    break;

                case KeyEvent.VK_DOWN:
                    if (textIndex >= textList.size() - 1)
                        return;

                    textIndex++;

                    text = textList.get(textIndex);
                    textField.setText(text);
                    break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        frame.add(textField, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setFocusTraversalPolicy(new LayoutFocusTraversalPolicy() {
            @Override
            public Component getInitialComponent(Window w) {
                return textField;
            }
        });
    }

}
