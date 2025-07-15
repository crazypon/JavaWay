package StreamAPI.Basics;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceMinMaxExample {
    // be careful when finding the min value and using identity, because it will be one of the elements, since
    // it is assigned to the first parameter of lambda
    static Optional<Integer> findMaxElement(List<Integer> nums) {
        return nums.stream()
                .reduce((a, b) -> a > b ? a : b);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 20, 35, 1, 23, 38);
        Optional<Integer> max = findMaxElement(numbers);
        System.out.println(max.isPresent() ? max.get() : "No max value found");
    }
}
