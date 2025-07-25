package ConcurrencyModule.ForkJoinFramework;

import java.util.concurrent.ForkJoinPool;

public class SimpleRecursiveActionDemo {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        SimpleRecursiveAction srt = new SimpleRecursiveAction(800);
        srt.invoke();

        System.out.println();
    }
}
