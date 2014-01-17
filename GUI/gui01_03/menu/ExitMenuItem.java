package gui01_03.menu;

import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ExitMenuItem extends MenuItem {

    public ExitMenuItem() {
        super("Exit");

        addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }

        });
    }

}
