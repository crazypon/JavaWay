package ConcurrencyModule.MultithreadingConcepts;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarketUpdater implements Runnable {
    @Override
    public void run() {
        System.out.println("Updating and downloading stock related data from web...");
    }
}


public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        /*
        with scheduled pool we can execute tasks at a certain rate, in this example we are executing the
        tasks every 5 seconds
         */
        service.scheduleAtFixedRate(new StockMarketUpdater(), 1000, 5000, TimeUnit.MILLISECONDS);
    }
}
