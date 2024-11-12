package FactoryDesignPattern.SimplePizzaFactory;

import FactoryDesignPattern.SimplePizzaFactory.Pizzas.Pizza;

public class Assembler {
    public static void main(String[] args) {
        PizzaFactory pizzaFactory = new PizzaFactoryImpl();
        PizzaStore pizzaStore = new PizzaStore(pizzaFactory);

        Pizza pizza = pizzaStore.orderPizza("Corn");

        System.out.println(pizza.getDescription() + ", Rs. " + pizza.getCost());
    }
}
