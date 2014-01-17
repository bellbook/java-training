package ch04.ex04_03;

public class Ex04_03 {

    public static void main(String[] args) {

        // インターフェースでなくてよい。

        LinkedListImpl list6 = new LinkedListImpl("!", null);
        LinkedListImpl list5 = new LinkedListImpl("o", list6);
        LinkedListImpl list4 = new LinkedListImpl("l", list5);
        LinkedListImpl list3 = new LinkedListImpl("l", list4);
        LinkedListImpl list2 = new LinkedListImpl("e", list3);
        LinkedListImpl list1 = new LinkedListImpl("H", list2);

        LinkedListImpl newList = list1.clone();

        list6.setData("?");

        System.out.println("----- original -----");
        list1.print();
        System.out.println("----- clone -----");
        newList.print();
    }

}
