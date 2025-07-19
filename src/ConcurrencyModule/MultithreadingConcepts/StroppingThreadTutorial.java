package ConcurrencyModule.MultithreadingConcepts;


class StoppingWorker implements Runnable{
    /*
    To make the thread stop, we should have volatile flag, to make sure that variable is not cached
    and does not get lost in memory. Also pay attention to the while loop
     */
    public static volatile boolean terminated = false;

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    @Override
    public void run() {
        while(!terminated) {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}

public class StroppingThreadTutorial {
    public static void main(String[] args) {
        StoppingWorker example = new StoppingWorker();
        Thread producer = new Thread(example);

        producer.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        example.setTerminated(true);
        System.out.println("Algorithm is terminated");

    }
}

