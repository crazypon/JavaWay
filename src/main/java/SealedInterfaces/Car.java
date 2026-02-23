package SealedInterfaces;

/*
To allow the child class to be inherited by certain classes you should mark as "sealed"
to allow any other class to be inherited you should mark as "non-sealed"
to prohibit inheritance mark as "final"
 */

public final class Car extends Vehicle implements SmartMediaPlayer{

    @Override
    public void connectPhone() {
        System.out.println("Phone connected");
    }

    @Override
    void sayHi() {
        System.out.println("hello");
    }
}
