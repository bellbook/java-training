package gui01_03.menu;

import gui01_03.DigitalClock;
import gui01_03.attribute.ColorEnum;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class FontColorMenu extends Menu {

    // Relationship
    private DigitalClock owner;

    // GUI Field
    private MenuItem menuItem;
    private MenuEventHandler menuEvent = new MenuEventHandler();

    public FontColorMenu(DigitalClock owner) {
        super("FontColor");

        this.owner = owner;

        for (ColorEnum e : ColorEnum.values()) {
            menuItem = new MenuItem(e.toString());
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
