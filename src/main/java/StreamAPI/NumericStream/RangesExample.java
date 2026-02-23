package StreamAPI.NumericStream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class RangesExample {
    public static void main(String[] args) {

        // creates stream of Integer 1-10
        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.forEach(System.out::println);

        System.out.println();

        // creates stream of Integer 1-9
        IntStream intStreamOpen = IntStream.range(1, 10);
        intStreamOpen.forEach(System.out::println);

        System.out.println();

        // since you can iterate through stream only once, I have to create stream again
        System.out.println("Closed Range Count: " + IntStream.rangeClosed(1, 10).count());
        System.out.println("Open Range Count: " + IntStream.range(1, 10).count());

        System.out.println();

        // we cannot create Double Stream range same way as showed above, that's why here is how we can create it
        DoubleStream doubleStream = IntStream.rangeClosed(1, 10).asDoubleStream();
        doubleStream.forEach(System.out::println);
    }
}
