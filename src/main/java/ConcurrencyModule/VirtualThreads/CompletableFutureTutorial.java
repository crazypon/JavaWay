package ConcurrencyModule.VirtualThreads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

public class CompletableFutureTutorial {
    /*
    This is a non-blocking future object, which notifies the main thread once value is available. This is a huge
    advantage since we are able to avoid blocking of the main thread
     */
    public static void main(String[] args) {
        try(var service = Executors.newVirtualThreadPerTaskExecutor()) {
            CompletableFuture
                    .supplyAsync(() -> "hello", service)
                    .thenCombine(CompletableFuture.supplyAsync(() -> "world"), (r1, r2) -> r1 + r2)
                    .thenApply(String::toUpperCase)
                    .thenAccept(s -> System.out.println(s));

        }

    }
}
