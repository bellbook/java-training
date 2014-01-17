package ch04.ex04_02;

public class TestSort {

    static Object[] testData = { 3, 1, 5, 2, 4 };

    public static void main(String[] args) {
        SortHarness bsort = new SimpleSortHarness();
        SortMetrics metrics = bsort.sort(testData);
        System.out.println("Metrics: " + metrics);
        for (int i = 0; i < testData.length; i++)
            System.out.println("\t" + testData[i]);
    }

}
