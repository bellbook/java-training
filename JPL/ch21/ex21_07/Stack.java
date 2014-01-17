package ch21.ex21_07;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<E> {

    private List<E> list = new ArrayList<E>();

    public E push(E item) {
        list.add(item);
        return item;
    }

    public E pop() {
        if (empty())
            throw new EmptyStackException();

        return list.remove(list.size() - 1);
    }

    public E peek() {
        if (empty())
            throw new EmptyStackException();

        return list.get(list.size() - 1);
    }

    public boolean empty() {
        return list.size() == 0;
    }

    public int search(Object o) {
        int lastIndex = list.lastIndexOf(o);

        if (lastIndex == -1)
            return -1;

        return list.size() - lastIndex;
    }

}
