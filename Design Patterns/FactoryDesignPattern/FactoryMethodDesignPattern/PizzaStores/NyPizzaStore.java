package FactoryDesignPattern.FactoryMethodDesignPattern.PizzaStores;

import FactoryDesignPattern.FactoryMethodDesignPattern.Pizzas.NyCheesePizza;
import FactoryDesignPattern.FactoryMethodDesignPattern.Pizzas.NyVeggiePizza;
import FactoryDesignPattern.FactoryMethodDesignPattern.Pizzas.Pizza;

public class NyPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        if(type.equals("Cheese")) {
            return new NyCheesePizza();
        } else if(type.equals("Veggie")) {
            return new NyVeggiePizza();
        }
        return null;
    }
    
}
