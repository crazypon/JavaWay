package StreamAPI.FactoryMethods;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfIterateGenerateTutorial {
    public static void main(String[] args) {
        // Stream.of(...) creates a stream
        System.out.println(Stream.of("Anny", "Benny", "Vinny").toList());

        // iterate() executes given function infinitely many times
        Stream.iterate(1, i -> i * 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Generate Example");

        // generate() is same as iterate(), but instead it takes Supplier<T>
        Supplier<Integer> random = new Random()::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
    }
}
