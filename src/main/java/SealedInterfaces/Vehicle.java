package SealedInterfaces;

/*
By making the class sealed you are giving access to extension only to certain classes,
child classes should be final (so that no other can extend from them, and get Vehicles properties as well) and should
extend from vehicle

By making class abstract we are able to use Interface-like functionality
 */
public sealed abstract class Vehicle permits Truck, Car{
    abstract void sayHi();
}
