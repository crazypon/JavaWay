package ConcurrencyModule.MultithreadingConcepts;

import java.util.concurrent.atomic.AtomicInteger;


public class AtomicTypesTutorial {
    /*
    Atomic types are just types, which have synchronized, so we don't have to think about
    synchronization
     */
    public static AtomicInteger counter = new AtomicInteger(0);

    public static void increment() {
        counter.getAndIncrement();
    }

    public static void process() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        process();
        System.out.println(counter);
    }
}
