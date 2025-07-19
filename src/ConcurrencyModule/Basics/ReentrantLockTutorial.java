package ConcurrencyModule;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTutorial {
    /*
    With ReentrantLock you can achieve the same behaviour as with "synchronized approach"
    ReentrantLock has constructor with "fairness" parameter, if it is set to true the longest
    waiting thread will acquire the lock (this is default). If it is set to false then no access
    order
     */

    private static int counter = 0;
    private static Lock lock = new ReentrantLock();

    public static void increment() {
        lock.lock();
        for(int i=0; i<10000;i++)
            counter++;
        lock.unlock();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> increment());
        Thread t2 = new Thread(() -> increment());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter: " + counter);
    }
}
