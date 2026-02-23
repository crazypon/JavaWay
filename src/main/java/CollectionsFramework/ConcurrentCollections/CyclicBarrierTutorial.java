package CollectionsFramework.ConcurrentCollections;


import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
CyclicBarrier is similar to CountDownLatch, but it is reusable, it can be reset()
 */

class BarrierWorker implements Runnable {
    private int id;
    private Random random;
    private CyclicBarrier barrier;

    public BarrierWorker(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
        this.random = new Random();
    }

    @Override
    public void run() {
        doWork();
    }

    private void doWork() {
        System.out.println("Thread with ID " + this.id + " starts the work...");
        try{
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            // await is going to block the thread, until the number of await() calls reaches the number of
            // parties (first parameter in the CyclicBarrier)
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("After await()...");
    }
}

public class CyclicBarrierTutorial {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // once the number of await() calls reaches the number of parties(it is 5 in our case)
        // our Runnable(Lambda) will be called
        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("All tasks have been finished"));

        for(int i = 0; i < 5; i++)
            executorService.execute(new BarrierWorker(i + 1, barrier));
    }
}
