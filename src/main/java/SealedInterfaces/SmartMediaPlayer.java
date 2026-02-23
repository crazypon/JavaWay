package SealedInterfaces;

/*
By making Interfaces sealed we allow to implement to the classes with permission
 */
public sealed interface SmartMediaPlayer permits Car{
    void connectPhone();
}
