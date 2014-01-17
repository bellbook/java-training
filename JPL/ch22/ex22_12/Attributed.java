package ch22.ex22_12;

import java.util.Iterator;

public interface Attributed {

    void add(Attr newAttr);

    Attr find(String attrName);

    Attr remove(String attrName);

    Iterator<Attr> attrs();

}
