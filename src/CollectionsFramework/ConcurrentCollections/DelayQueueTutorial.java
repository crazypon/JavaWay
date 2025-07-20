package CollectionsFramework.ConcurrentCollections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*
So DelayQueue is another thread-safe Data Structure, meaning several threads can work with it. When taking
an element from the DelayQueue the most expired one will be returned. If there is no expired element than null will
be returned instead. size() method or isEmpty() method will consider not expired elements as well when returning values
 */

class DelayedElement implements Delayed {

    private long duration;
    private String message;

    public DelayedElement(long duration, String message) {
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(duration > ((DelayedElement) o).getDuration())
            return 1;
        if(duration < ((DelayedElement) o).getDuration())
            return -1;
        return 0;
    }

    public Long getDuration() {
        return duration;
    }


    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

    public class DelayQueueTutorial {
    public static void main(String[] args) {
        BlockingQueue<DelayedElement> messageQueue = new DelayQueue<>();

        try {
            messageQueue.put(new DelayedElement(3000, "Hello World"));
            messageQueue.put(new DelayedElement(10000, "All I wanted was you"));
            messageQueue.put(new DelayedElement(7000, "Baby, hear me tonight"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while(!messageQueue.isEmpty()) {
            try {
                System.out.println(messageQueue.take().getMessage());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
