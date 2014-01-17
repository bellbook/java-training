package ch22.ex22_04;

import java.util.Observable;
import java.util.Observer;

public class Ex22_04 {

    public static void main(String[] args) {

        Observer observer = new Ex22_04().new MyObserver();

        Attributed attrs = new AttributedImpl();
        ((Observable) attrs).addObserver(observer);

        Attr attr = new Attr("apple", 1);
        attrs.add(attr);
        attrs.remove("apple");
    }

    class MyObserver implements Observer {

        @Override
        public void update(Observable arg0, Object arg1) {
            System.out.println(arg1);
        }

    }

}
