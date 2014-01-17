package gui02_01;

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
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class DigitalClock extends JFrame {

    public static void main(String[] args) {
        DigitalClock dc = new DigitalClock();
        dc.setVisible(true);
    }

    // Constant
    private static final int WIDTH  = 180;
    private static final int HEIGHT = 60;
    private static final int DELAY  = 1000; // time

    public DigitalClock() {

        JPanel panel = new ViewPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        panel.setBackground(Color.WHITE);
        add(panel);

        // configure this frame
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class ViewPanel extends JPanel implements ActionListener {

        public ViewPanel() {
            Timer timer = new Timer(DELAY, this);
            timer.start();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setFont(new Font("Arial", Font.BOLD, 36));

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
