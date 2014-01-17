package gui02_03.menu;

import gui02_03.DigitalClock;
import gui02_03.attribute.ColorEnum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class FontColorMenu extends JMenu {

    // Relationship
    private DigitalClock owner;

    // GUI Field
    private JMenuItem menuItem;
    private MenuEventHandler menuEvent = new MenuEventHandler();

    public FontColorMenu(DigitalClock owner) {
        super("FontColor");

        this.owner = owner;

        for (ColorEnum e : ColorEnum.values()) {
            menuItem = new JMenuItem(e.toString());
            menuItem.addActionListener(menuEvent);
            add(menuItem);
        }
    }

    class MenuEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            for (ColorEnum e : ColorEnum.values()) {
                if (ae.getActionCommand().equals(e.toString())) {
                    owner.setFontColor(e.getColor());
                    break;
                }
            }
        }
    }

}
