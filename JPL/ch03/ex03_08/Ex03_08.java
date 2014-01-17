package ch03.ex03_08;

public class Ex03_08 {

    public static void main(String[] args) {

        // 4つの内の一番目。cloneをサポートする。

        // 正しい。

        Vehicle car1 = new Vehicle();
        car1.setOwner("Adam");
        Vehicle car2 = (Vehicle) car1.clone();
        car1.setOwner("Eve");

        System.out.println("original = " + car1);
        System.out.println("clone    = " + car2);
    }

}
