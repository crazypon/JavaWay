package CollectionsFramework.ConcurrentCollections;


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class FirstCMapWorker implements Runnable {
    ConcurrentMap<String, Integer> map;

    public FirstCMapWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            map.put("A", 12);
            Thread.sleep(1000);
            map.put("C", 234);
            Thread.sleep(2000);
            map.put("O", 42);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SecondCMapWorker implements Runnable {
    ConcurrentMap<String, Integer> map;

    public SecondCMapWorker(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            System.out.println(map.get("A"));
            Thread.sleep(1000);
            System.out.println(map.get("O"));
            Thread.sleep(2000);
            System.out.println(map.get("C"));
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }


}

public class ConcurrentMapTutorial {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

        FirstCMapWorker firstCMapWorker = new FirstCMapWorker(map);
        SecondCMapWorker secondCMapWorker = new SecondCMapWorker(map);

        Thread t1 = new Thread(firstCMapWorker);
        Thread t2 = new Thread(secondCMapWorker);

        t1.start();
        t2.start();
    }
}
