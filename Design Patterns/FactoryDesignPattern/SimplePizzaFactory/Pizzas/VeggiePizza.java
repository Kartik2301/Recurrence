package FactoryDesignPattern.SimplePizzaFactory.Pizzas;

public class VeggiePizza extends Pizza {

    public VeggiePizza() {
        name = "Veggie";
    }

    @Override
    public int getCost() {
        return 150;
    }

    @Override
    public String getDescription() {
        return "Delightful Veggie Pizza";
    }
    
}
