package ConcurrencyModule.Basics;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExample {
    public static List<Integer> bufferList = new ArrayList<>();
    public static final int MAX_LIMIT = 5;
    public static final int LOW_LIMIT = 0;
    public static int value = 0;

    public static final Object lock = new Object();

    public void producer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if(bufferList.size() == MAX_LIMIT) {
                    System.out.println("List is full, waiting consumer to free up space");
                    // if you are defining custom lock you should call wait() and notify()
                    // on that lock
                    lock.wait();
                } else {
                    System.out.println("Adding value: " + value);
                    bufferList.add(value);
                    value++;
                    // we can call the notify() - because the other thread will be notified
                    // only when it is in a waiting state
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if(bufferList.size() == LOW_LIMIT) {
                    System.out.println("List is full, waiting consumer to free up space");
                    value = 0;
                    lock.wait();
                } else {
                    System.out.println("Removing value: " + bufferList.removeLast());
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerExample example = new ProducerConsumerExample();
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

        // showing how to set a priority to the threads, here this code changes nothing
        // this is the priority by default
        producer.setPriority(Thread.NORM_PRIORITY);
        consumer.setPriority(Thread.NORM_PRIORITY);

        producer.start();
        consumer.start();

    }
}
