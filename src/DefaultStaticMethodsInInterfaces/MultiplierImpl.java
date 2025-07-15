package DefaultStaticMethodsInInterfaces;

import java.util.List;

public class MultiplierImpl implements Multiplier {
    @Override
    public int multiply(List<Integer> nums) {
        return nums.stream()
                .reduce(1, (x, y) -> x * y);
    }

    @Override
    public int arraySize(List<Integer> nums) {
        System.out.println("I am Overridden default method");
        return nums.size();
    }

    // you cannot override static sayHello() method here!
}
