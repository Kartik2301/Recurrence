package FactoryDesignPattern.FactoryMethodDesignPattern.Pizzas;

public class NyCheesePizza extends Pizza {
    public NyCheesePizza() {
        name = "Ny Cheese Pizza";
        sauce = "Ketchup";
        toppings.add("Herbs");
        crust = "doughy";
    }
}
