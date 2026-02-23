package DesignPatterns.Decorator;

public class PepperoniTopping extends PizzaTopping{

    public PepperoniTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public int getCost() {
        return pizza.getCost() + 1;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }
}
