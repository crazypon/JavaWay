package StreamAPI.NumericStream;

import java.util.List;
import java.util.stream.IntStream;

public class MapToTutorial {
    static List<Integer> mapToObjectExample() {
        return IntStream.rangeClosed(1, 5)
                // mapToObj() can is used for custom objects, for educational purposes just mapped to Integer
                .mapToObj(Integer::valueOf)
                .toList();
    }

    static long mapToLongExample() {
        return IntStream.rangeClosed(1, 5)
                .mapToLong(Long::valueOf)
                .sum();
    }

    static double mapToDoubleExample() {
        return IntStream.rangeClosed(1, 5)
                .mapToDouble(Double::valueOf)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(mapToObjectExample());
        System.out.println(mapToLongExample());
        System.out.println(mapToDoubleExample());
    }
}
