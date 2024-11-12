package FactoryDesignPattern.FactoryMethodDesignPattern.PizzaStores;

import FactoryDesignPattern.FactoryMethodDesignPattern.Pizzas.Pizza;

public abstract class PizzaStore {
    public final void orderPizza(String type) {
        Pizza pizza = createPizza(type);
        
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    protected abstract Pizza createPizza(String type);
}
