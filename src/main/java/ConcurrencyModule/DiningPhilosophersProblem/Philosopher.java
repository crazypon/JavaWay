package ConcurrencyModule.DiningPhilosophersProblem;

import java.util.Random;

public class Philosopher implements Runnable{
    private int id;
    private volatile boolean isFull; // to terminate the threads
    private ChopStick leftStick;
    private ChopStick rightStick;
    private Random random;
    private int eatingCounter;

    public Philosopher(int id, ChopStick leftStick, ChopStick rightStick){
        this.id = id;
        this.leftStick = leftStick;
        this.rightStick = rightStick;
        random = new Random();
    }

    @Override
    public void run() {
        try{
            while(!isFull){
                think();
                if(leftStick.pickUp(this, State.LEFT)){
                    if(rightStick.pickUp(this, State.RIGHT)){
                        eat();
                        rightStick.putDown(this, State.RIGHT);
                    }
                    // so if right stick is not available, philosopher won't eat
                    // and return stick back immediately
                    leftStick.putDown(this, State.LEFT);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void think() throws InterruptedException{
        System.out.println(this + " is thinking");
        Thread.sleep(random.nextInt(1000));
    }

    private void eat() throws InterruptedException{
        System.out.println(this + " is eating");
        eatingCounter++;
        Thread.sleep(random.nextInt(1000));
    }

    public void setFull(boolean full){
        isFull = full;
    }

    public boolean isFull() {
        return isFull;
    }

    public int getEatingCounter() {
        return eatingCounter;
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}
