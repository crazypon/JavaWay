package ConcurrencyModule.ForkJoinFramework;

import java.util.concurrent.RecursiveAction;


/*
Every task in Fork-Join framework should implement RecursiveAction if the task does not return anything
or RecursiveTask<T> if it returns something
 */

public class SimpleRecursiveAction extends RecursiveAction {

    private int simulatedWork;

    public SimpleRecursiveAction(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {
        if(simulatedWork > 100) {
            System.out.println("Work is too big, splitting it: " + simulatedWork);

            SimpleRecursiveAction srt1 = new  SimpleRecursiveAction(simulatedWork/2);
            SimpleRecursiveAction srt2 = new  SimpleRecursiveAction(simulatedWork/2);

            invokeAll(srt1, srt2); // forks all tasks(executes them)
        } else {
            System.out.println("Work is small enough, executing: " + simulatedWork);
        }
    }
}
