package ch11.ex11_01;

public class LinkedList<E> {

    private E data;
    private LinkedList<E> next;

    public void add(E o) {

        LinkedList<E> p = this.next;
        LinkedList<E> q = this;

        while (p != null) {
            q = p;
            p = p.next;
        }

        LinkedList<E> newList = new LinkedList<E>();
        newList.setData(o);

        newList.next = p;
        q.next = newList;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LinkedList [data=" + data + "]";
    }

    public void print() {
        if (next != null) {
            System.out.println(next);
            next.print();
        }
    }

}
