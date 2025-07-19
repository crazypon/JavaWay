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
            e.printStackTrace();
        }
    }
}

public class SingleThreadExecutor {
    public static void main(String[] args) {
        // creates a single thread, which executes the tasks sequentially
        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++)
            service.execute(new Task(i+1));
    }
}
