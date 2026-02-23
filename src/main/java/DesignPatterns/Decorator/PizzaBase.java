package DesignPatterns.Decorator;


// here we define the base
public class PizzaBase implements Pizza {

    @Override
    public int getCost() {
        return 5;
    }

    @Override
    public String getDescription() {
        return "Pizza Dough with the following ingredients: ";
    }
}
