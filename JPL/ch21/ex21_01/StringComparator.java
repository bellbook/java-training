package ch21.ex21_01;

import java.util.Comparator;

@SuppressWarnings("rawtypes")
public class StringComparator implements Comparator {

    @Override
    public int compare(Object arg0, Object arg1) {
        return ((String) arg0).compareTo((String) arg1);
    }

}
