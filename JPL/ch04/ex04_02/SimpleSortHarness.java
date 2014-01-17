package ch04.ex04_02;

public class SimpleSortHarness implements SortHarness {

    private SortHarnessImpl sortImpl = new SortHarnessImpl();

    @Override
    public SortMetrics sort(Object[] data) {
        return sortImpl.sort(data);
    }

    @Override
    public SortMetrics getMetrics() {
        return sortImpl.getMetrics();
    }

    @Override
    public int getDataLength() {
        return sortImpl.getDataLength();
    }

    @Override
    public Object probe(int i) {
        return sortImpl.probe(i);
    }

    @Override
    public int compare(int i, int j) {
        return sortImpl.compare(i, j);
    }

    @Override
    public void swap(int i, int j) {
        sortImpl.swap(i, j);
    }

    @Override
    public void doSort() {
        sortImpl.doSort();
    }

}
