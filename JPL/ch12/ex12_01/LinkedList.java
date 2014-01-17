package ch12.ex12_01;

public class LinkedList<E> {

    private Object data;
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

    public void setData(Object data) {
        this.data = data;
    }

    public LinkedList<E> find(E o) throws ObjectNotFoundException {

        if (next != null) {
            if (next.data == o) {
                return next;
            }
            return next.find(o);
        }
        throw new ObjectNotFoundException().setObj(o);
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
