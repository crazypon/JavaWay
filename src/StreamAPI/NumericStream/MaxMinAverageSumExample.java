package StreamAPI.NumericStream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MaxMinAverageSumExample {
    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 10);
        System.out.println(intStream.average());

        IntStream intStream1 = IntStream.rangeClosed(1, 10);
        OptionalInt optionalInt = intStream1.min();
        optionalInt.ifPresent(System.out::println);

        IntStream intStream2 = IntStream.rangeClosed(1, 10);
        System.out.println(intStream2.max().getAsInt());

        IntStream intStream3 = IntStream.rangeClosed(1, 10);
        System.out.println(intStream3.sum());
    }
}
