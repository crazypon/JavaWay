package ConcurrencyModule.Basics;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockProducerConsumer {

    public static final Lock lock = new ReentrantLock();
    public static final Condition condition = lock.newCondition();

    public void producer() throws InterruptedException {
        try {
            // acquiring the lock, meaning no other thread can run this method till we unlock
            lock.lock();
            System.out.println("In Producer Method");
            // blocking the current, meaning that thread is paused, till other thread notifies
            condition.await();
            System.out.println("Again in Producer Method");
        } finally {
            // thread must be unlocked at any cost so that we avoid deadlock situations
            lock.unlock();
        }

    }

    public void consumer() throws InterruptedException {
        try {
            Thread.sleep(2000);
            lock.lock();
            System.out.println("In Consumer Method");
            Thread.sleep(3000);
            // similar to notify()
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockProducerConsumer example = new LockProducerConsumer();
        Thread producer = new Thread(() -> {
            try {
                example.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                example.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();

    }
}
