package ConcurrencyModule.Basics;

/*
In SynchronizedDemo I told about a problem of having a single lock, that two independent
synchronized methods cannot work at the same time (same time means time-slicing not parallelly)
to fix that just create two objects, so that two locks(monitors) are created, then specify
the locks for synchronized blocks.

Now you may think, why are we doing that, we could just create two threads on each independent
operation and that's it, no need to sync them, and you are right. But imagine, what would happen
if those independent operations had two threads each
 */

public class SynchronizedDemo2 {

    public static int counter1 = 0;
    public static int counter2 = 0;

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void increment1() {
        synchronized (lock1) {
            counter1++;
        }
    }

    public static void increment2() {
        synchronized (lock2) {
            counter2++;
        }
    }

    public static void process() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment1();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment2();
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
        System.out.println(counter1);
        System.out.println(counter2);
    }
}
