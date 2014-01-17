package ch03.ex03_07;

public class Ex03_07 {

    public static void main(String[] args) {
        ColorAttr red = new ColorAttr("red");
        ColorAttr green = new ColorAttr("green");
        ColorAttr blue = new ColorAttr("blue");

        System.out.println("red.equals(red)   = " + red.equals(red));
        System.out.println("red.equals(green) = " + red.equals(green));

        System.out.println("red.hashCode()   = " + red.hashCode());
        System.out.println("green.hashCode() = " + green.hashCode());
        System.out.println("blue.hashCode()  = " + blue.hashCode());
    }

}
