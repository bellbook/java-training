package ch04.ex04_02;

public class SortHarnessImpl implements SortHarness {

    private Object[] values;
    private final SortMetrics curMetrics = new SortMetrics();

    public final SortMetrics sort(Object[] data) {
        values = data;
        curMetrics.init();
        doSort();
        return getMetrics();
    }

    public final SortMetrics getMetrics() {
        return curMetrics.clone();
    }

    public final int getDataLength() {
        return values.length;
    }

    public final Object probe(int i) {
        curMetrics.compareCnt++;
        return values[i];
    }

    public final int compare(int i, int j) {
        curMetrics.compareCnt++;
        Object obj1 = values[i];
        Object obj2 = values[j];
        if (obj1 == obj2)
            return 0;
        else
            return (obj1.hashCode() < obj2.hashCode() ? -1 : 1);
    }

    public final void swap(int i, int j) {
        curMetrics.swapCnt++;
        Object tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    @Override
    public void doSort() {
        for (int i = 0; i < getDataLength(); i++) {
            for (int j = i + 1; j < getDataLength(); j++) {
                if (compare(i, j) > 0)
                    swap(i, j);
            }
        }
    }

}
