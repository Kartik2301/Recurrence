package FactoryDesignPattern.SimplePizzaFactory;

import FactoryDesignPattern.SimplePizzaFactory.Pizzas.Pizza;

public interface PizzaFactory {
    public Pizza createPizza(String type);
}
