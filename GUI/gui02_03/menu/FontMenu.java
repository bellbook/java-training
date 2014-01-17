package gui02_03.menu;

import gui02_03.DigitalClock;
import gui02_03.attribute.FontEnum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class FontMenu extends JMenu {

    // Relationship
    private DigitalClock owner;

    // GUI Field
    private JMenuItem menuItem;
    private MenuEventHandler menuEvent = new MenuEventHandler();

    public FontMenu(DigitalClock owner) {
        super("Font");

        this.owner = owner;

        for (FontEnum e : FontEnum.values()) {
            menuItem = new JMenuItem(e.toString());
            menuItem.addActionListener(menuEvent);
            add(menuItem);
        }
    }

    class MenuEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            for (FontEnum e : FontEnum.values()) {
                if (ae.getActionCommand().equals(e.toString())) {
                    owner.setFont(e.getFont());
                    break;
                }
            }
        }
    }

}
