package DefaultStaticMethodsInInterfaces;

public interface Interface4 {
    default void methodA() {
        System.out.println("Interface4");
    }
}
