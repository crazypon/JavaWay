package CollectionsFramework.ConcurrentCollections;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
With the help of CountDownLatch we can synchronize threads by forcing them to wait till the other thread
performs n number of operations, once n is equal to 0 it will be notified

CountDownLatch is one-shot event, meaning you cannot reuse it, for reusability opt for Cyclic Barriers
 */
class LatchWorker implements Runnable {
    private int id;
    private CountDownLatch latch;

    public LatchWorker(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        doWork();
        // this decrements the number of operations that should be done, so that other thread once it is equal to 0
        // can continue its work
        latch.countDown();
    }

    private void doWork() {
        System.out.println("Doing some work, BIP BIP BOP");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class CountDownLatchTutorial {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 3; i++)
            executor.execute(new LatchWorker(i + 1, latch));

        Thread customThread = new Thread(() -> {
            try {
                latch.await();
                System.out.println("Custom Thread, doing some work, right after Latch gives me permission");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        customThread.start();
        // this is for the MAIN thread
        latch.await();
        System.out.println("All tasks are done");
        executor.shutdown();

    }
}
