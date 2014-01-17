package ch06.ex06_04;

import java.awt.Color;

public enum SignalColor {

    GREEN(Color.GREEN), YELLOW(Color.YELLOW), RED(Color.RED);

    Color color;

    SignalColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
