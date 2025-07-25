package ConcurrencyModule.ForkJoinFramework;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MaxExample {
    public static void main(String[] args) {
        int[] nums = createArray();

        SequentialMax sm = new SequentialMax(nums);
        ParallelMax pm = new ParallelMax(nums, 0, nums.length - 1);

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        System.out.println("SequentialMax: " + sm.sequentialFindMax());
        System.out.println("ParallelMax" + pool.invoke(pm));
    }

    public static int[] createArray() {
        int[] arr = new int[10000000];
        Random rand = new Random();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }
}
