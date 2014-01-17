package ch04.ex04_03;

public class LinkedListImpl implements LinkedList, Cloneable {

    private Object data;
    private LinkedListImpl next;

    public LinkedListImpl(Object data, LinkedListImpl next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getItemNum() {

        if (next == null)
            return 1;
        else
            return 1 + next.getItemNum();
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

    public LinkedListImpl clone() {
        try {
            LinkedListImpl list = (LinkedListImpl) super.clone();
            if (next != null) {
                list.next = (LinkedListImpl) next.clone();
            }
            return list;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }

}
