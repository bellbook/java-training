package gui02_02.attribute;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum ColorEnum {

    BLACK (Color.BLACK, "Black", new ImageIcon("resources/gui/color_chip/black.png")),
    WHITE (Color.WHITE, "White", new ImageIcon("resources/gui/color_chip/white.png")),
    RED   (Color.RED,   "Red",   new ImageIcon("resources/gui/color_chip/red.png")),
    GREEN (Color.GREEN, "Green", new ImageIcon("resources/gui/color_chip/green.png")),
    BLUE  (Color.BLUE,  "Blue",  new ImageIcon("resources/gui/color_chip/blue.png")),
    ;

    private final Color color;
    private final String name;
    private final Icon icon;

    ColorEnum(Color color, String name, Icon icon) {
        this.color = color;
        this.name = name;
        this.icon = icon;
    }

    public Color getColor() {
        return color;
    }

    public Icon getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return name;
    }

}
