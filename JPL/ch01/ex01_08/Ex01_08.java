package ch01.ex01_08;

public class Ex01_08 {

    public static void main(String[] args) {

        Point p1 = new Point();
        Point p2 = new Point();

        p1.x = 1;
        p1.y = 2;

        p2.x = 3;
        p2.y = 4;

        p1.setPoint(p2);
        System.out.println("p1(x, y) = (" + p1.x + ", " + p1.y + ")");
    }

}
