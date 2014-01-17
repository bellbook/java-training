package gui02_03.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class ExitMenuItem extends JMenuItem {

    public ExitMenuItem() {
        super("Exit");

        addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }

        });
    }

}
