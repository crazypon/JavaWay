package DesignPatterns.Decorator;


// Here we just define
public abstract class PizzaTopping implements Pizza {
    protected Pizza pizza;

    public PizzaTopping(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}
