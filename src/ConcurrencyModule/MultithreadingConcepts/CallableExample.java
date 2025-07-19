package ConcurrencyModule.MultithreadingConcepts;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/*
Callable is just as Runnable interface, while Runnable's run method does not return any value, in Callable's call
you can return values of any types.
 */

class CallableWorker implements Callable<String> {
    private int id;

    CallableWorker(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "ID: " + id;
    }
}

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> futures = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Future<String> myFuture = executorService.submit(new CallableWorker(i + 1));
            futures.add(myFuture);
        }

        for(Future<String> f : futures){
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            };
        }
    }
}
