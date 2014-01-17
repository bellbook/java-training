package gui01_02.menu;

import gui01_02.DigitalClock;
import gui01_02.PropertyDialog;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ToolMenu extends Menu {

    // Relationship
    private DigitalClock owner;
    private PropertyDialog property;

    // Field
    private MenuItem menuItem;
    private MenuEventHandler menuEvent = new MenuEventHandler();

    public ToolMenu(DigitalClock owner) {
        super("Tool");
        this.owner = owner;

        menuItem = new MenuItem(MenuEnum.PROPERTY.toString());
        menuItem.addActionListener(menuEvent);
        add(menuItem);
    }

    class MenuEventHandler implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            if (ae.getActionCommand().equals(MenuEnum.PROPERTY.toString())) {
                if (property == null) {
                    property = new PropertyDialog(owner);
                }
                property.setVisible(true);
            }

        }
    }

}
