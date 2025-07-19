package ConcurrencyModule;


public class SynchronizedDemo {
    public static int counter = 0;

    public static void increment() {
        /*
        You can make whole method synchronized, but this is not considered a good practice,
        instead create a synchronized block, don't put all your code inside of it, just the one
        that accesses the shared resource (counter1 in our case).

        This block will guarantee that only one thread has access to counter1 at a time, using
        intrinsic lock of this class, which means we only have one lock. Which is bad, since we
        may have completely independent methods, which modify completely independent variables,
        lock will lock as well if one thread gets the resource even if the other thread is not going
        to use it (see SynchronizedDemo2)

        If method is static you should write (SomeClass.class), if it is not then you
        can write as (this)
         */
        synchronized (SynchronizedDemo.class) {
            counter++;
        }
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
