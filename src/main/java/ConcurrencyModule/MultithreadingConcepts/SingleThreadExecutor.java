package ConcurrencyModule.MultithreadingConcepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Executors are like pools for our threads, we need them in order to create several of them.
Executors play role of manager of threads.

Moreover, created threads are being reused which makes thread pools very efficient
 */


public class SingleThreadExecutor {
    public static void main(String[] args) {
        // creates a single thread, which executes the tasks sequentially
        ExecutorService service = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++)
            // Task is inside FixedThreadPool, I put it there to show how thread shutdown works
            service.execute(new Task(i+1));
    }
}
