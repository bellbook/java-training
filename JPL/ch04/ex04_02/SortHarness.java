package ch04.ex04_02;

public interface SortHarness {

    SortMetrics sort(Object[] data);

    SortMetrics getMetrics();

    int getDataLength();

    Object probe(int i);

    int compare(int i, int j);

    void swap(int i, int j);

    void doSort();

}
