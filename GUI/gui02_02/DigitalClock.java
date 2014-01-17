package gui02_02;

import gui02_02.attribute.ColorEnum;
import gui02_02.attribute.FontEnum;
import gui02_02.attribute.SizeEnum;
import gui02_02.menu.ToolMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class DigitalClock extends JFrame {

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
    private JMenuBar menuBar = new JMenuBar();

    public DigitalClock(String title) {
        super(title);

        // configure menubar
        menuBar.add(new ToolMenu(this));
        //
        // add menus here
        //
        setJMenuBar(menuBar);

        // layout
        panel = new ViewPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setBackground(backgroundColor);
        add(panel);

        // configure this frame
        setBackground(backgroundColor);
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void changeSizeEvent() {
        double rate = (double) fontSize / SizeEnum._36.getSize();
        panel.setPreferredSize(new Dimension((int) (WIDTH * rate), (int) (HEIGHT * rate)));
        pack();

        panel.revalidate();
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

    class ViewPanel extends JPanel implements ActionListener {

        public ViewPanel() {
            Timer timer = new Timer(DELAY, this);
            timer.start();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setFont(new Font(font, Font.BOLD, fontSize));
            g.setColor(fontColor);
            setBackground(backgroundColor);

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String time = sdf.format(date);

            FontMetrics fm = g.getFontMetrics();
            int x = (this.getWidth() - fm.stringWidth(time)) / 2;
            int y = (this.getHeight() + fm.getAscent() - fm.getDescent()) / 2;
            g.drawString(time, x, y);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

    }

}
