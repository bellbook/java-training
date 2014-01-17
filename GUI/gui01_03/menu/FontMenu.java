package gui01_03.menu;

import gui01_03.DigitalClock;
import gui01_03.attribute.FontEnum;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class FontMenu extends Menu {

    // Relationship
    private DigitalClock owner;

    // GUI Field
    private MenuItem menuItem;
    private MenuEventHandler menuEvent = new MenuEventHandler();

    public FontMenu(DigitalClock owner) {
        super("Font");

        this.owner = owner;

        for (FontEnum e : FontEnum.values()) {
            menuItem = new MenuItem(e.toString());
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
