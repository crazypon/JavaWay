package DefaultStaticMethodsInInterfaces;

public interface Interface3 extends Interface2{
    default void methodC() {
        System.out.println("Interface3");
    }

    @Override
    default void methodB() {
        System.out.println("Interface3");
    }
}
