package gui01_03.menu;

import gui01_03.DigitalClock;
import gui01_03.attribute.SizeEnum;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class FontSizeMenu extends Menu {

    // Relationship
    private DigitalClock owner;

    // GUI Field
    private MenuItem menuItem;
    private MenuEventHandler menuEvent = new MenuEventHandler();

    public FontSizeMenu(DigitalClock owner) {
        super("FontSize");

        this.owner = owner;

        for (SizeEnum e : SizeEnum.values()) {
            menuItem = new MenuItem(e.toString());
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
