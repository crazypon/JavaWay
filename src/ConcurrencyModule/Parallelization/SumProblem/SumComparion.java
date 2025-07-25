package ConcurrencyModule.Parallelization.SumProblem;

import java.util.Random;

public class SumComparion {

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums =  new int[1000000000];

        for(int i = 0; i < 1000000000; i++) {
            nums[i] = random.nextInt();
        }

        long start1 = System.currentTimeMillis();
        SequentialSum sq = new  SequentialSum();
        System.out.println("Sequential Sum: " + sq.sum(nums));
        long end1 = System.currentTimeMillis();
        System.out.println("Sequential computed in: " + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        ParallelSumDemo ps = new ParallelSumDemo(numberOfProcessors);
        System.out.println("Parallel Sum: " + ps.sum(nums));
        long end2 = System.currentTimeMillis();
        System.out.println("Parallel Sum computed in: " + (end2 - start2) + "ms");

    }
}
