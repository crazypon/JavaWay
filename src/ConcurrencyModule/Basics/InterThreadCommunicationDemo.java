package ConcurrencyModule;
/*
Some Vocabulary
Acquiring the lock: Thread gets exclusive access (meaning it is running).
Releasing the lock: Thread is done, lets others use it (no longer running).

Inter thread communication in java, is when to thread communicate with each other,
they tell when they either acquire or release the block. To communicate wait() and notify()
are used. They should be inside synchronized method or block
 */

public class InterThreadCommunicationDemo {
    public void produce() throws InterruptedException {
        synchronized(this) {
            System.out.println("Running the producer method...");
            // tells the current thread which is running this method to stop here, until other
            // thread from the scope of the lock calls notify()
            wait();
            System.out.println("Again in the producer method...");
        }
    }

    public void consume() throws InterruptedException {
        // sleeping to make sure producer waits first
        Thread.sleep(500);
        synchronized(this) {
            System.out.println("Consume method is executed...");
            // notify is not releasing the lock immediately once it is called, it releases once
            // all statements in synchronized block are executed, pay attention to the pause to
            // when executing to see the difference
            notify();
            Thread.sleep(5000);
        }
    }


    public static void main(String[] args) {
        InterThreadCommunicationDemo mobj = new InterThreadCommunicationDemo();
        Thread t1 = new Thread(() -> {
            try {
                mobj.consume();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                mobj.produce();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        t1.start();
        t2.start();
    }
}
