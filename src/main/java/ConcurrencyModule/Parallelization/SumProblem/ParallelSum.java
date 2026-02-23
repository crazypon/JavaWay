package ConcurrencyModule.Parallelization.SumProblem;

/*
The difference between linear and parallel sum is that parallel version is going to split the
array, each tread will sum up its own part, and finally all threads will combine their results
 */
public class ParallelSum extends Thread {
    private int[] nums;
    private int low;
    private int high;
    private int partialSum = 0;

    public ParallelSum(int[] nums, int low, int high) {
        this.nums = nums;
        this.low = low;
        this.high = Math.min(nums.length, high);
    }
    @Override
    public void run() {
        for(int i = low; i < high; i++)
            partialSum += nums[i];

    }

    public int getPartialSum() {
        return partialSum;
    }
}
