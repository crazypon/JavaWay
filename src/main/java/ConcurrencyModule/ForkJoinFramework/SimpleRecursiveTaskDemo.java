package ConcurrencyModule.ForkJoinFramework;

import java.util.concurrent.ForkJoinPool;

public class SimpleRecursiveTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        SimpleRecursiveTask srt = new SimpleRecursiveTask(1000);
        double result = srt.invoke();
        System.out.println(result);
    }
}
