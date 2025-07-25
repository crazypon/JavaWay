package ConcurrencyModule.Parallelization.MergeSort;

import java.util.Random;

public class MergeSortComparison {
    public static void main(String[] args) {
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        int[] numbers1 = createArray(10000000);
        int[] numbers2 = new int[numbers1.length];

        for(int i = 0; i < numbers1.length; i++)
            numbers2[i] = numbers1[i];

        // PARALLEL MERGE SORT
        MergeSort parallelMergeSort = new MergeSort(numbers1);

        long startTime1 = System.currentTimeMillis();
        parallelMergeSort.parallelMergeSort(0, numbers1.length - 1, numOfThreads);
        long endTime1 = System.currentTimeMillis();

        System.out.println("Parallel Merge Sorting time: " + (endTime1 - startTime1));

        //SEQUANTIAL MERGE SORT
        startTime1 = System.currentTimeMillis();
        MergeSort sequentialMergeSort = new MergeSort(numbers2);
        sequentialMergeSort.mergeSort(0, numbers2.length - 1);
        long startTime2 = System.currentTimeMillis();

        System.out.println("Sequential Merge Sorting time: " + (startTime2 - startTime1));
    }

    private static int[] createArray(int n) {
        Random random = new Random();
        int[] a = new int[n];

        for(int i = 0; i < n; i++)
            a[i] = random.nextInt(n);
        return a;
    }
}
