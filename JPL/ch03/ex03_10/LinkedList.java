package ch03.ex03_10;

public class LinkedList implements Cloneable {

    private Object data;
    private LinkedList next;

    public LinkedList(Object data, LinkedList next) {
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

    public LinkedList clone() {
        try {
            LinkedList list = (LinkedList) super.clone();
            if (next != null) {
                list.next = (LinkedList) next.clone();
            }
            return list;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }

    public LinkedList clone0() {
        try {
            return (LinkedList) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString());
        }
    }

}
