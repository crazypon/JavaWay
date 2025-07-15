package StreamAPI.NumericStream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BoxingUnboxingTutorial {
    /*
    boxed() performs boxing operation and creates a stream
     */
    static List<Integer> toBox() {
        return IntStream.rangeClosed(1, 10)
                // int
                .boxed()
                // Integer
                .toList();

    }

    // converting stream to IntStream so that we can use sum(), average(), min(), max() functions
    static int unbox(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(toBox());
        System.out.println(unbox(list));
    }
}
