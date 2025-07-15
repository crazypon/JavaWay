package StreamAPI.ParallelStream;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamTutorial {
    static Long checkPerformance(Supplier<Integer> myStream, int numberOfTimes) {
        Long startTime = System.currentTimeMillis();

        for(int i = 0; i < numberOfTimes; i++) {
            myStream.get();
        }

        Long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    static int sequentialStream() {
        return IntStream.rangeClosed(1, 100000)
                .sum();
    }

    static int parallelStream() {
        return IntStream.rangeClosed(1, 100000)
                .parallel()
                .sum();
    }

    public static void main(String[] args) {
        /*
        parallel streams are not always better than sequential, you should use them only when they give you
        performance advantage

        Always check the performance to see if parallel stream is needed or not

        Times when parallel streams have weak performance:
        1. When it has to perform unboxing
        2. When threads share the same variable or any other resource, it is not about performance, the result will not
        be accurate since we are creating race condition
         */
        System.out.println("Sequential Stream: " + checkPerformance(ParallelStreamTutorial::sequentialStream, 300));
        System.out.println("Parallel Stream: " + checkPerformance(ParallelStreamTutorial::parallelStream, 300));
    }
}
