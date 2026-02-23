package CollectionsFramework.ConcurrentCollections;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/*
CopyOnWriteArrayList is another concurrent collection. It is good for reading, since
reading operation is thread-safe and fast, however writing operation is expensive , it is
linear( O(N) );
 */

class ReadTask implements Runnable {
    private List<Integer> list;

    public ReadTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(list);
        }
    }
}

class WriteTask implements Runnable {
    private List<Integer> list;
    private Random random;

    public WriteTask(List<Integer> list) {
        this.list = list;
        random = new Random();
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.set(random.nextInt(list.size()), random.nextInt(10));
        }
    }
}

public class CopyOnWriteArrayTutorial {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.addAll(Arrays.asList(0, 0, 0 , 0, 0, 0, 0, 0, 0, 0));

        ReadTask readTask = new ReadTask(list);
        WriteTask writeTask = new WriteTask(list);

        Thread readThread = new Thread(readTask);
        Thread writeThread = new Thread(writeTask);
        readThread.start();
        writeThread.start();
    }
}
