package gui01_02;

import gui01_02.attribute.ColorEnum;
import gui01_02.attribute.FontEnum;
import gui01_02.attribute.SizeEnum;
import gui01_02.menu.ToolMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class DigitalClock extends Frame {

    public static void main(String[] args) {
        DigitalClock dc = new DigitalClock("Digital Clock");
        dc.setVisible(true);
    }

    // Constant
    private static final int WIDTH  = 180;
    private static final int HEIGHT = 60;
    private static final int DELAY  = 1000; // time

    // Relationship
    private ViewPanel panel;

    // Field
    private String font            = FontEnum.ARIAL.getFont();
    private int    fontSize        = SizeEnum._36.getSize();
    private Color  fontColor       = ColorEnum.BLACK.getColor();
    private Color  backgroundColor = ColorEnum.WHITE.getColor();

    // GUI Field
    private MenuBar menuBar = new MenuBar();

    public DigitalClock(String title) {
        super(title);

        // configure menubar
        menuBar.add(new ToolMenu(this));
        //
        // add menus here
        //
        setMenuBar(menuBar);

        // layout
        panel = new ViewPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(panel);

        // configure this frame
        setResizable(false);
        pack();
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void changeSizeEvent() {
        double rate = (double) fontSize / SizeEnum._36.getSize();
        panel.setPreferredSize(new Dimension((int) (WIDTH * rate), (int) (HEIGHT * rate)));
        pack();

        panel.repaint();
   }

    public void setFont(String font) {
        this.font = font;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    class ViewPanel extends Panel implements ActionListener {

        // Double-Buffering Field
        private Image    iBuffer;
        private Graphics gBuffer;

        public ViewPanel() {
            Timer timer = new Timer(DELAY, this);
            timer.start();
        }

        public void createBuffer() {
            Dimension d = this.getSize();
            iBuffer = createImage(d.width, d.height);
            gBuffer = iBuffer.getGraphics();
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            this.createBuffer();

            // paint buffer
            gBuffer.setFont(new Font(font, Font.BOLD, fontSize));
            gBuffer.setColor(fontColor);
            setBackground(backgroundColor);

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String time = sdf.format(date);

            FontMetrics fm = gBuffer.getFontMetrics();
            int x = (this.getWidth()  - fm.stringWidth(time)) / 2;
            int y = (this.getHeight() + fm.getAscent() - fm.getDescent()) / 2;
            gBuffer.drawString(time, x, y);
            g.drawImage(iBuffer, 0, 0, this);
        }

        @Override
        public void update(Graphics g) {
            this.paint(g);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();

        }

    }

}
