package FunctionalInterface;

public class FuncInterfaceDemo {
    static void calculateMath(GenericInterface<String, Integer> g, int num) {
        System.out.println(g.myFunc(num));
    }

    public static void main(String[] args) {
        calculateMath(a -> String.valueOf(3.14 * a * a), 4);
    }
}
