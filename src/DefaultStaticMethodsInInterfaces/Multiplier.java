package DefaultStaticMethodsInInterfaces;

import java.util.List;

public interface Multiplier {

    int multiply(List<Integer> numbers);

    /*
    if there is a choice between default method in interface and overridden method inside a class, it will opt for
    overridden one
     */
    default int arraySize(List<Integer> numbers) {
        return numbers.size();
    }

    /*
    You cannot override static method
     */
    static void sayHello() {
        System.out.println("Hello");
    }

}
