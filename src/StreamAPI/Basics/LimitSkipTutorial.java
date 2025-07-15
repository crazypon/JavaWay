package StreamAPI.Basics;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LimitSkipTutorial {
    /*
    limit(n) gives you first n elements, skipping all the others
     */
    static Optional<Integer> limitExample(List<Integer> numbers) {
        return numbers.stream()
                .limit(3)
                .reduce((a, b) -> a * b);
    }

    /*
    skip(n) skips first n elements, leaving all the other
     */
    static Optional<Integer> skipExample(List<Integer> numbers) {
        return numbers.stream()
                .skip(3)
                .reduce((a, b) -> a * b);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 390, 2, 345, 23);
        Optional<Integer> myLim = limitExample(numbers);
        myLim.ifPresent(System.out::println);

        Optional<Integer> mySkip = skipExample(numbers);
        mySkip.ifPresent(System.out::println);
    }
}
