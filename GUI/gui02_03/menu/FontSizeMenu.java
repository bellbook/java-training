package gui02_03.menu;

import gui02_03.DigitalClock;
import gui02_03.attribute.SizeEnum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class FontSizeMenu extends JMenu {

    // Relationship
    private DigitalClock owner;

    // GUI Field
    private JMenuItem menuItem;
    private MenuEventHandler menuEvent = new MenuEventHandler();

    public FontSizeMenu(DigitalClock owner) {
        super("FontSize");

        this.owner = owner;

        for (SizeEnum e : SizeEnum.values()) {
            menuItem = new JMenuItem(e.toString());
            menuItem.addActionListener(menuEvent);
            add(menuItem);
        }
    }

    class MenuEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            for (SizeEnum e : SizeEnum.values()) {
                if (ae.getActionCommand().equals(e.toString())) {
                    owner.setFontSize(e.getSize());
                    owner.changeSizeEvent();
                    break;
                }
            }
        }
    }

}
