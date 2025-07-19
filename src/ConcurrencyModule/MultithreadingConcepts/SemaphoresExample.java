package ConcurrencyModule.MultithreadingConcepts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;


// this is called singleton design patter. you should know design patterns
enum Downloader {
    INSTANCE;

    private Semaphore semaphore = new Semaphore(3, true);
    public void download() {
        try {
            semaphore.acquire();
            downloadData();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private void downloadData() {
        try {
            System.out.println("Downloading data from the internet...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SemaphoresExample {
    /*
    So far we have been using locks and synchronized blocks to synchronize our threads. This way
    is called Mutex. This method gives access to only one thread. In Semaphore method we can give
    access to several threads, so several of them can acquire the lock.

    Semaphore(int numberOfResources, boolean fairness) has acquire() method, which gets the
    resource if available, release() returns the resource (lock) back, so that other thread can
    use it;

    After running the code you will notice that only three thread at a time can have access to
    the download method
     */
    public static void main(String[] args) {
        // this thing creates threads
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i<12;i++) {
            executorService.execute(Downloader.INSTANCE::download);
        }
    }
}
