package ch02.ex02_14;

public class LinkedList {

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
