package ch03.ex03_10;

public class Ex03_10 {

    public static void main(String[] args) {

        LinkedList list6 = new LinkedList("!", null);
        LinkedList list5 = new LinkedList("o", list6);
        LinkedList list4 = new LinkedList("l", list5);
        LinkedList list3 = new LinkedList("l", list4);
        LinkedList list2 = new LinkedList("e", list3);
        LinkedList list1 = new LinkedList("H", list2);

        LinkedList newList = list1.clone();
        LinkedList newList0 = list1.clone0();

        list6.setData("?");

        System.out.println("----- original -----");
        list1.print();
        System.out.println("----- clone -----");
        newList.print();
        System.out.println("----- clone0 -----");
        newList0.print();
    }

}
