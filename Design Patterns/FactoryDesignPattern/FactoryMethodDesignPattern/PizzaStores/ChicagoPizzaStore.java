package FactoryDesignPattern.FactoryMethodDesignPattern.PizzaStores;

import FactoryDesignPattern.FactoryMethodDesignPattern.Pizzas.ChicagoCheesePizza;
import FactoryDesignPattern.FactoryMethodDesignPattern.Pizzas.ChicagoVeggiePizza;
import FactoryDesignPattern.FactoryMethodDesignPattern.Pizzas.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        if(type.equals("Cheese")) {
            return new ChicagoCheesePizza();
        } else if(type.equals("Veggie")) {
            return new ChicagoVeggiePizza();
        }
        return null;
    }
    
}
