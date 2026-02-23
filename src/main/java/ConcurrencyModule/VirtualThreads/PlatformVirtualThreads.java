package ConcurrencyModule.VirtualThreads;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlatformVirtualThreads {
    public static void main(String[] args) {
        /*
        Here we can create threads with the help of executor services
         */

        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();

        for(int i = 0; i < 1000000; i++){
            service.submit(
                    () -> {
                        System.out.println("Executing " + Thread.currentThread());
                        try {
                            Thread.sleep(Duration.ofSeconds(10));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
    }
}
