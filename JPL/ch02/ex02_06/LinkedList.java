package ch02.ex02_06;

public class LinkedList {

    public Object data;
    public LinkedList next;

    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList list3 = new LinkedList();

        Vehicle car = new Vehicle();
        car.speed = 100;
        car.direction = 60;
        car.owner = "Jack";

        Vehicle bike = new Vehicle();
        bike.speed = 180;
        bike.direction = 30;
        bike.owner = "Mike";

        Vehicle plane = new Vehicle();
        plane.speed = 270;
        plane.direction = 90;
        plane.owner = "John";

        list1.data = car;
        list1.next = list2;

        list2.data = bike;
        list2.next = list3;

        list3.data = plane;
        list3.next = null;

        list1.print();
    }

    public void print() {
        System.out.println(data);

        if (next != null) {
            next.print();
        }
    }

}
