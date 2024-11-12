package FactoryDesignPattern.SimplePizzaFactory;

import FactoryDesignPattern.SimplePizzaFactory.Pizzas.CheesePizza;
import FactoryDesignPattern.SimplePizzaFactory.Pizzas.CornPizza;
import FactoryDesignPattern.SimplePizzaFactory.Pizzas.Pizza;
import FactoryDesignPattern.SimplePizzaFactory.Pizzas.VeggiePizza;

public class PizzaFactoryImpl implements PizzaFactory {

    @Override
    public Pizza createPizza(String type) {
        if(type.equals("Veggie")) {
            return new VeggiePizza();
        } else if(type.equals("Corn")) {
            return new CornPizza();
        } else if(type.equals("Cheese")) {
            return new CheesePizza();
        }
        return null;
    }
    
}
