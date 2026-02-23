package LambdaFunInterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/*
Consumer Interface is made to accept function as an argument in function.
Consider .forEach() method, it takes Consumer as an argument, so that you can
pass lambdas.
As its name suggests Consumer, must have only one parameter and performs some kind of operations, and returns nothing
(it only consumes)
BiConsumer for two parameters
 */

public class ConsumerExample {
    static List<Integer> list = Arrays.asList(1, 10, 5, 4, 99, 20, 2_000_000);
    public static void main(String[] args) {

        // Consumer example
        Consumer<Integer> consumer = number -> {if(number % 2 == 0) System.out.println(number);};
        list.forEach(consumer);

        // BiConsumer example
        BiConsumer<Integer, Integer> multiply = (n1, n2) ->
                System.out.println("Multiplication: " + (n1 * n2));
        BiConsumer<Integer, Integer> divide = (n1, n2) ->
                System.out.println("Division: " + (n1 / n2));

        // andThen() tells to perform another lambda right after another
        // accept() is method of Consumer/BiConsumer functional interface
        multiply.andThen(divide).accept(144, 12);
    }
}
