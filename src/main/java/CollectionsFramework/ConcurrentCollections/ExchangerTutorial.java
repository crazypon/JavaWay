package CollectionsFramework.ConcurrentCollections;


import java.util.concurrent.Exchanger;

/*
With Exchanger Threads are able to exchange some data with each other, when one thread calls
exchange it gets blocked till other thread calls it as well. So in our case two threads are
exchanging counter values.
 */

class FirstExchanger implements Runnable {
    private Integer counter = 0;
    private Exchanger<Integer> exhanger;

    public FirstExchanger(Exchanger<Integer> exhanger) {
        this.exhanger = exhanger;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("First Exchanger Counter " + counter);
            System.out.println("First Exchanger Incrementing Counter " + (++counter));
            try {
                counter = exhanger.exchange(counter);
                System.out.println("First Counter After Exchange " + counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class SecondExchanger implements Runnable {
    private Integer counter = 0;
    private Exchanger<Integer> exhanger;

    public SecondExchanger(Exchanger<Integer> exhanger) {
        this.exhanger = exhanger;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Second Exchanger Counter " + counter);
            System.out.println("Second Exchanger Decrementing Counter " + (--counter));
            try {
                counter = exhanger.exchange(counter);
                System.out.println("Second Counter After Exchange " + counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class ExchangerTutorial {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        FirstExchanger firstExchanger = new FirstExchanger(exchanger);
        SecondExchanger secondExchanger = new SecondExchanger(exchanger);

        new Thread(firstExchanger).start();
        new Thread(secondExchanger).start();
    }
}
