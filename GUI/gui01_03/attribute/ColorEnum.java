package gui01_03.attribute;

import java.awt.Color;

public enum ColorEnum {

    BLACK (Color.BLACK, "Black"),
    WHITE (Color.WHITE, "White"),
    RED   (Color.RED,   "Red"),
    GREEN (Color.GREEN, "Green"),
    BLUE  (Color.BLUE,  "Blue"),
    ;

    private final Color color;
    private final String name;

    ColorEnum(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return name;
    }

}
