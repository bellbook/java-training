package ch14.ex14_06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Observable {

    private List<Object> observers = new ArrayList<Object>();

    public void addObserver(Object observer) {
        observers.add(observer);
    }

    public void notifyObservers() {

        for (Iterator<Object> i = observers.iterator(); i.hasNext();) {
            Observer observer = (Observer) i.next();
            observer.update();
        }
    }

}
