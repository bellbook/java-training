package ch11.ex11_02;

import java.awt.Color;

public class Ex11_02 {

    public static void main(String[] args) {
        Attr<Color> red = new Attr<Color>("red", Color.red);
        Attr<Color> green = new Attr<Color>("green", Color.green);
        Attr<Color> blue = new Attr<Color>("blue", Color.blue);

        System.out.println(red.getName() + ": " + red.getValue());
        System.out.println(green.getName() + ": " + green.getValue());
        System.out.println(blue.getName() + ": " + blue.getValue());
    }

}
