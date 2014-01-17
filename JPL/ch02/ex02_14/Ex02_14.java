package ch02.ex02_14;

public class Ex02_14 {

    public static void main(String[] args) {
        LinkedList list6 = new LinkedList("!", null);
        LinkedList list5 = new LinkedList("o", list6);
        LinkedList list4 = new LinkedList("l", list5);
        LinkedList list3 = new LinkedList("l", list4);
        LinkedList list2 = new LinkedList("e", list3);
        LinkedList list1 = new LinkedList("H", list2);

        System.out.println(list1.getData());
        System.out.println(list2.getData());
        System.out.println(list3.getData());
        System.out.println(list4.getData());
        System.out.println(list5.getData());
        System.out.println(list6.getData());
    }

}
