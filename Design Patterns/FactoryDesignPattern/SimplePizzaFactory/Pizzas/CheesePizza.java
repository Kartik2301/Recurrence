package FactoryDesignPattern.SimplePizzaFactory.Pizzas;

public class CheesePizza extends Pizza {

    public CheesePizza() {
        name = "Cheese";
    }

    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public String getDescription() {
        return "A Delicious Cheese Pizza";
    }
    
}
