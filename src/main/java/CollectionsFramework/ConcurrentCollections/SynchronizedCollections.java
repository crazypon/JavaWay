package CollectionsFramework.ConcurrentCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollections {

    public static void main(String[] args) {
        /*
        This way we can obtain  a synchronized version of the collection, however it has problems, very similar to
        synchronized locks. There we use only intrinsic lock, meaning even independent threads will be blocked if
        one thread obtains the lock
         */
        List<Integer> nums = Collections.synchronizedList(new ArrayList<>());

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                nums.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                nums.add(i);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(nums.size());
    }
}
