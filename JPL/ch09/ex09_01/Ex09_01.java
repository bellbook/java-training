package ch09.ex09_01;

public class Ex09_01 {

    public static void main(String[] args) {
        Double pi = Double.POSITIVE_INFINITY;
        Double ni = Double.NEGATIVE_INFINITY;

        System.out.println(" ∞ +  ∞ = " + (pi + pi));
        System.out.println(" ∞ + -∞ = " + (pi + ni));
        System.out.println(" ∞ -  ∞ = " + (pi - pi));
        System.out.println(" ∞ - -∞ = " + (pi - ni));
        System.out.println(" ∞ *  ∞ = " + (pi * pi));
        System.out.println(" ∞ * -∞ = " + (pi * ni));
        System.out.println(" ∞ /  ∞ = " + (pi / pi));
        System.out.println(" ∞ / -∞ = " + (pi / ni));
    }

}
