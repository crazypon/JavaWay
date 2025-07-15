package DefaultStaticMethodsInInterfaces;

public interface Interface1 {
    default void methodA() {
        System.out.println("Interface1");
    }
}
