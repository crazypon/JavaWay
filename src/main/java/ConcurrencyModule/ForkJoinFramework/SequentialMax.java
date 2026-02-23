package ConcurrencyModule.ForkJoinFramework;

public class SequentialMax {
    private int[] nums;

    public SequentialMax(int[] nums) {
        this.nums = nums;
    }

    public int sequentialFindMax() {
        int max = nums[0];
        for(int n : nums) {
            if(n > max)
                max = n;
        }
        return max;
    }
}
