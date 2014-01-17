package ch03.ex03_12;

public abstract class SortHarness {

    protected Object[] values;
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

    protected final int getDataLength() {
        return values.length;
    }

    protected final Object probe(int i) {
        curMetrics.compareCnt++;
        return values[i];
    }

    protected abstract int compare(int i, int j);

    protected final void swap(int i, int j) {
        curMetrics.swapCnt++;
        Object tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    protected abstract void doSort();

}
