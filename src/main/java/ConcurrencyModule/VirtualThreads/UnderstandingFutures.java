package ConcurrencyModule.VirtualThreads;

import java.util.concurrent.*;

/*
So as you Future is blocking (get method is blocking), if you need non-blocking use CompletableFuture instead.
It does not notify the thread when the value is available, which is a disadvantage
 */

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Starting " + Thread.currentThread().getName());
        var start = System.currentTimeMillis();
        Thread.sleep(2000);
        var finish = System.currentTimeMillis();
        System.out.println("Finishing " + Thread.currentThread().getName() + " in " + (finish-start) + "ms");
        return "THREAD RESULT";
    }
}

public class UnderstandingFutures {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<String> result = service.submit(new MyCallable());

        // this way we can avoid main thread blocking
        while(!result.isDone()) {
            System.out.println("waiting for result");
        }
        // res blocks the main thread
        String res = result.get();

        System.out.println(res);
    }
}
