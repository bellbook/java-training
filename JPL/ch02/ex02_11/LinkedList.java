package ch02.ex02_11;

public class LinkedList {

    public Object data;
    public LinkedList next;

    public static void main(String[] args) {
        LinkedList list6 = new LinkedList("!", null);
        LinkedList list5 = new LinkedList("o", list6);
        LinkedList list4 = new LinkedList("l", list5);
        LinkedList list3 = new LinkedList("l", list4);
        LinkedList list2 = new LinkedList("e", list3);
        LinkedList list1 = new LinkedList("H", list2);

        list1.print();
    }

    public LinkedList(Object data, LinkedList next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedList [data=" + data + "]";
    }

    public void print() {
        System.out.println(this);

        if (next != null) {
            next.print();
        }
    }

}
