package DefaultStaticMethodsInInterfaces;

public interface Interface2 extends Interface1{
    default void methodB() {
        System.out.println("Interface2");
    }

    @Override
    default void methodA() {
        System.out.println("Inside Interface 2");
    }
}
