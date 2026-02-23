package ConcurrencyModule.DiningPhilosophersProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhilosophersSimulation {
    public static void main(String[] args) throws InterruptedException{
        ExecutorService executor = null;
        Philosopher[] philosophers = null;
        ChopStick[] chopSticks = null;

        try{
            philosophers = new Philosopher[Constants.NUMBER_OF_PHILOSOPHERS];
            chopSticks = new ChopStick[Constants.NUMBER_OF_CHOPSTICKS];

            for(int i = 0; i<Constants.NUMBER_OF_PHILOSOPHERS; i++)
                chopSticks[i] = new ChopStick(i);

            executor = Executors.newFixedThreadPool(Constants.NUMBER_OF_PHILOSOPHERS);

            for(int i = 0; i<Constants.NUMBER_OF_PHILOSOPHERS; i++){
                // we applied here modulus because of the last philosopher,
                // for him left stick is stick number 0
                philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i+1)%Constants.NUMBER_OF_CHOPSTICKS]);
                executor.execute(philosophers[i]);
            }

            Thread.sleep(Constants.SIMULATION_TIME);

            for(Philosopher philosopher: philosophers){
                philosopher.setFull(true);

            }
        } finally {
            executor.shutdown();
            while(!executor.isTerminated()) {
                Thread.sleep(1000);
            }
            for(Philosopher philosopher: philosophers){
                System.out.println(philosopher + " eat " + philosopher.getEatingCounter() + " times");
            }
        }
    }
}
