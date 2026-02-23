package ConcurrencyModule.Parallelization.SumProblem;

import javax.naming.PartialResultException;

public class ParallelSumDemo {
    private ParallelSum[] workers;
    private int numOfThreads;

    public ParallelSumDemo(int numOfThreads) {
        this.numOfThreads = numOfThreads;
        this.workers = new ParallelSum[numOfThreads];
    }

    public int sum(int[] nums) {
        int size = (int) Math.ceil(nums.length * 1.0 / numOfThreads);

        for(int i=0; i<numOfThreads; i++) {
            workers[i] = new ParallelSum(nums, i * size, (i+1) * size);
            workers[i].start();
        }

        for(ParallelSum worker : workers) {
            try {
                worker.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // summing up sub-results
        int total = 0;
        for(ParallelSum worker : workers) {
            total += worker.getPartialSum();
        }
        return total;
    }

    public static void main(String[] args) {

    }
}
