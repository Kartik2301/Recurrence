package FactoryDesignPattern.FactoryMethodDesignPattern.Pizzas;

public class NyVeggiePizza extends Pizza {
    public NyVeggiePizza() {
        name = "Ny Veggie Pizza";
        sauce = "Mayo";
        toppings.add("Cheese");
        crust = "Thin";
    }
}
