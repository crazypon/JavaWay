package DefaultStaticMethodsInInterfaces;

public class MultipleInheritanceExample implements Interface1, Interface2, Interface3, Interface4{

    /*
    if default interface method is overridden inside of class this method will be called
    if default interface method is overridden inside of child interface, this method will be called
    if there is overridden default method inside child interface and there is overridden version inside of class, the
    last one will be called
     */

    /*
    Inside Interface1 and Interface4 there is the same default method, moreover Interface4 is not inheriting Interface1
    to resolve the conflict write it's implementation inside implementation class
     */
    @Override
    public void methodA() {
        System.out.println("Inside of " + MultipleInheritanceExample.class);
    }

    public static void main(String[] args) {
        MultipleInheritanceExample c = new MultipleInheritanceExample();

        c.methodA(); // Java will opt for implementation of child interface(checkout Interface1)
        c.methodB();
        c.methodC();
    }
}
