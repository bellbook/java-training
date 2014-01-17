package gui02_04;

import gui02_04.attribute.ColorEnum;
import gui02_04.attribute.FontEnum;
import gui02_04.attribute.SizeEnum;
import gui02_04.menu.ToolMenu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.prefs.Preferences;

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
    private FontEnum  fontEnum            = FontEnum.ARIAL;
    private SizeEnum  fontSizeEnum        = SizeEnum._36;
    private ColorEnum fontColorEnum       = ColorEnum.BLACK;
    private ColorEnum backgroundColorEnum = ColorEnum.WHITE;

    // GUI Field
    private JMenuBar menuBar = new JMenuBar();

    // Preferences
    private Preferences prefs = Preferences.userNodeForPackage(this.getClass());
    private static final String FONT_KEY             = "FONT";
    private static final String FONT_SIZE_KEY        = "FONT_SIZE";
    private static final String FONT_COLOR_KEY       = "FONT_COLOR";
    private static final String BACKGROUND_COLOR_KEY = "BACKGROUND_COLOR";
    private static final String X_KEY                = "X";
    private static final String Y_kEY                = "Y";

    public DigitalClock(String title) {
        super(title);

        this.loadPrefs();

        // configure menubar
        menuBar.add(new ToolMenu(this));
        //
        // add menus here
        //
        setJMenuBar(menuBar);

        // layout
        panel = new ViewPanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(panel);

        // configure this frame
        changeSizeEvent();
        setResizable(false);
        pack();
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {

                savePrefs();

                System.exit(0);
            }
        });
    }

    public void changeSizeEvent() {
        double rate = (double) fontSizeEnum.getSize() / SizeEnum._36.getSize();
        panel.setPreferredSize(new Dimension((int) (WIDTH * rate), (int) (HEIGHT * rate)));
        pack();

        panel.revalidate();
   }

    public FontEnum getFontEnum() {
        return fontEnum;
    }

    public void setFontEnum(FontEnum fontEnum) {
        this.fontEnum = fontEnum;
    }

    public SizeEnum getFontSizeEnum() {
        return fontSizeEnum;
    }

    public void setFontSizeEnum(SizeEnum fontSizeEnum) {
        this.fontSizeEnum = fontSizeEnum;
    }

    public ColorEnum getFontColorEnum() {
        return fontColorEnum;
    }

    public void setFontColorEnum(ColorEnum fontColorEnum) {
        this.fontColorEnum = fontColorEnum;
    }

    public ColorEnum getBackgroundColorEnum() {
        return backgroundColorEnum;
    }

    public void setBackgroundColorEnum(ColorEnum backgroundColorEnum) {
        this.backgroundColorEnum = backgroundColorEnum;
    }

    private void loadPrefs() {

        String fontPrefs            = prefs.get(FONT_KEY, null);
        String fontSizePrefs        = prefs.get(FONT_SIZE_KEY, null);
        String fontColorPrefs       = prefs.get(FONT_COLOR_KEY, null);
        String backgroundColorPrefs = prefs.get(BACKGROUND_COLOR_KEY, null);
        String xPrefs               = prefs.get(X_KEY, null);
        String yPrefs               = prefs.get(Y_kEY, null);

        if (fontPrefs != null)
            fontEnum = FontEnum.valueOf(fontPrefs);

        if (fontSizePrefs != null)
            fontSizeEnum = SizeEnum.valueOf(fontSizePrefs);

        if (fontColorPrefs != null)
            fontColorEnum = ColorEnum.valueOf(fontColorPrefs);

        if (backgroundColorPrefs != null)
            backgroundColorEnum = ColorEnum.valueOf(backgroundColorPrefs);

        int x = 0;
        if (xPrefs != null)
            x = Integer.parseInt(xPrefs);

        int y = 0;
        if (yPrefs != null)
            y = Integer.parseInt(yPrefs);

        setLocation(x, y);
    }

    private void savePrefs() {

        prefs.put(FONT_KEY, fontEnum.name());
        prefs.put(FONT_SIZE_KEY, fontSizeEnum.name());
        prefs.put(FONT_COLOR_KEY, fontColorEnum.name());
        prefs.put(BACKGROUND_COLOR_KEY, backgroundColorEnum.name());
        prefs.put(X_KEY, String.valueOf(getX()));
        prefs.put(Y_kEY, String.valueOf(getY()));
    }

    class ViewPanel extends JPanel implements ActionListener {

        public ViewPanel() {
            Timer timer = new Timer(DELAY, this);
            timer.start();
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);

            g.setFont(new Font(fontEnum.getFont(), Font.BOLD, fontSizeEnum.getSize()));
            g.setColor(fontColorEnum.getColor());
            setBackground(backgroundColorEnum.getColor());

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String time = sdf.format(date);

            FontMetrics fm = g.getFontMetrics();
            int x = (this.getWidth()  - fm.stringWidth(time)) / 2;
            int y = (this.getHeight() + fm.getAscent() - fm.getDescent()) / 2;
            g.drawString(time, x, y);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

    }

}
