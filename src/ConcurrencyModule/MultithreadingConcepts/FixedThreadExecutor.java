package ConcurrencyModule.MultithreadingConcepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
Executors are like pools for our threads, we need them in order to create several of them.
Executors play role of manager of threads.
 */

class Task implements Runnable {
    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id " + id + " is in work -- thread id: " + Thread.currentThread().getId());
        Long duration = (long) (Math.random() * 5);
        try{
            TimeUnit.SECONDS.sleep(duration);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class FixedThreadExecutor {
    public static void main(String[] args) {
        // creates a pool with five threads, which will execute the task
        ExecutorService service = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 25; i++)
            service.execute(new Task(i+1));

        // with this code we prevent to execute any further tasks, basically our program will quit once we call this
        service.shutdown();

        // terminate actual (running) tasks
        try{
            if(!service.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                // use this method to shut down tasks immediately, if you leave it like this our
                //service.shutdownNow();
            }
        } catch(InterruptedException e) {

        }
    }
}
