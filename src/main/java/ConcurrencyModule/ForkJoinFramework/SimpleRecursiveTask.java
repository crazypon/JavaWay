package ConcurrencyModule.ForkJoinFramework;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Double> {
    private double value;

    public SimpleRecursiveTask(double value) {
        this.value = value;
    }

    @Override
    protected Double compute() {
        if(value > 50) {
            System.out.println("This number is to small, splitting it");

            SimpleRecursiveTask srt1 = new SimpleRecursiveTask(value/2);
            SimpleRecursiveTask srt2 = new SimpleRecursiveTask(value/2);

            srt1.fork();
            srt2.fork();

            double sum = 0;
            // always call compute() for first task, as it will save some resources
            sum += srt1.compute() + srt2.join();
            return sum;
        } else {
            System.out.println("Number is small enough, performing operation: " + value);
            return value * 2;
        }
    }
}
