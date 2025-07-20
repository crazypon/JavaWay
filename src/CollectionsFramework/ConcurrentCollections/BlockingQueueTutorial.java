package CollectionsFramework.ConcurrentCollections;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
BlockingQueue works very interesting. Once the queue reaches its full capacity, the thread that called put() will be
blocked until other thread frees up some space using take() method. So put() and take() are like wait() and notify().
As you may have noticed Concurrent DataStructures are very handy, since there is no need to create Locks or
synchronized blocks, just create DS, create threads and work.
 */

class FirstWorker implements Runnable {
    private BlockingQueue<Integer> queue;
    private int counter = 0;

    public FirstWorker(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                queue.put(++counter);
                System.out.println("Adding " + counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class SecondWorker implements Runnable {
    private BlockingQueue<Integer> queue;

    public SecondWorker(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("removing " + queue.take());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
public class BlockingQueueTutorial {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        FirstWorker firstWorker = new FirstWorker(queue);
        SecondWorker secondWorker = new SecondWorker(queue);

        Thread t1 = new Thread(firstWorker);
        Thread t2 = new Thread(secondWorker);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
