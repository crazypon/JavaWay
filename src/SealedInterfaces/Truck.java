package SealedInterfaces;

/*
To allow the child class to be inherited by certain classes you should mark as "sealed"
to allow any other class to be inherited you should mark as "non-sealed"
to prohibit inheritance mark as "final"
 */
public final class Truck extends Vehicle {
    @Override
    void sayHi() {
        System.out.println("hello");
    }
}
