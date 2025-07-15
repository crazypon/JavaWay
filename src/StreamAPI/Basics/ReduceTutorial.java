package StreamAPI.Basics;

import data.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static data.StudentDatabase.getStudentsDatabase;

public class ReduceTutorial {
    /*
    reduce() is known as accumulation function, identity parameter is the first parameter of lambda where
    reduce accumulates or stores the result, by performing some kind of operation on each element

    reduce() returns single value from the stream by performing the operation you specify with lambda expression, you
    can remember this by "reduces stream to one thing"

    reduce() itself is a terminal operator
     */

    public static int multiplyAllNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(1, (a, b) -> a * b);
    }

    public static Optional<Integer> multiplyWithoutIdentity(List<Integer> numbers) {
        return numbers.stream()
                .reduce((a, b) -> a * b);
    }

    public static Optional<Student> getHighestGPAStudent() {
        return getStudentsDatabase().stream()
                .reduce((s1, s2) -> (s1.getGpa() > s2.getGpa()) ? s1 : s2);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 33, 4, 3);
        System.out.println(multiplyAllNumbers(numbers));

        Optional<Integer> result = multiplyWithoutIdentity(numbers);
        result.ifPresent(System.out::println);

        System.out.print("Student with highest GPA: ");
        getHighestGPAStudent().ifPresent(s -> System.out.print(s.getName()));


    }
}
