package ConcurrencyModule.VirtualThreads;

import java.util.concurrent.Executors;

class VirtualTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Starting " + Thread.currentThread().getName());
        var start = System.currentTimeMillis();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        var finish = System.currentTimeMillis();
        System.out.println("Finishing " + Thread.currentThread().getName() + " in " + (finish-start) + "ms");
    }
}

public class VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        // this is the best approach of creating a virtual thread, since it will implicitly wait our virtual thread
        // to finish
        try(var service = Executors.newVirtualThreadPerTaskExecutor()) {
            service.submit(new VirtualTask());
            service.submit(new VirtualTask());
            service.submit(new VirtualTask());
        }




//        var factory = Thread.ofVirtual().name("virtual-", 0).factory();
//
//        var t1 = factory.newThread(new VirtualTask());
//        var t2 = factory.newThread(new VirtualTask());
//
//        t1.start();
//        t2.start();
//
//        // all virtual threads are daemon threads, that's why we should join them, otherwise once main thread
//        // finishes they will be destroyed
//        t1.join();
//        t2.join();
    }
}
