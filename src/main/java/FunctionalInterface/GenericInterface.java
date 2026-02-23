package FunctionalInterface;

// this is just for demonstration purposes, Function defined in java.lang interface is better option, since it is
// already written
public interface GenericInterface<T, Y> {
    T myFunc(Y t);
}
