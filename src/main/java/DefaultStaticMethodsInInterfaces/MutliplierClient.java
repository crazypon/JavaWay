package DefaultStaticMethodsInInterfaces;

import java.util.Arrays;
import java.util.List;

public class MutliplierClient {
    public static void main(String[] args) {
        Multiplier myMultiplier = new MultiplierImpl();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(myMultiplier.multiply(numbers));

        System.out.println(myMultiplier.arraySize(numbers));
        Multiplier.sayHello();
    }
}
