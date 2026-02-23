package ConcurrencyModule.ForkJoinFramework;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ParallelMax extends RecursiveTask<Integer> {
    private int[] nums;
    private int lowIndex;
    private int highIndex;

    public ParallelMax(int[] nums, int lowIndex, int highIndex) {
        this.nums = nums;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    @Override
    protected Integer compute() {
        if(nums.length > 10000) {

            int mid = nums.length / 2;

            int[] left = Arrays.copyOfRange(nums, lowIndex, mid);
            int[] right = Arrays.copyOfRange(nums, mid, highIndex);

            ParallelMax parallelMax1 = new ParallelMax(left, lowIndex, mid);
            ParallelMax parallelMax2 = new ParallelMax(right, mid + 1, highIndex);

            parallelMax1.fork();
            parallelMax2.fork();

            int value1 = parallelMax1.join();
            int value2 = parallelMax2.join();

            System.out.println(value1);
            System.out.println(value2);

            return Math.max(value1, value2);
        } else {

            SequentialMax sm = new SequentialMax(nums);
            int num = sm.sequentialFindMax();
            return num;
        }
    }
}
