package ch22.ex22_15;

import javax.swing.JFrame;

import ch22.ex22_15.gui.AppCalculator;

public class Ex22_15 {

    public static void main(String args[]) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        AppCalculator calculator = new AppCalculator();
        calculator.setVisible(true);
    }

}
