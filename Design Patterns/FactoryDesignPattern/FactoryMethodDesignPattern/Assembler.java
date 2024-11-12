package FactoryDesignPattern.FactoryMethodDesignPattern;

import FactoryDesignPattern.FactoryMethodDesignPattern.PizzaStores.ChicagoPizzaStore;
import FactoryDesignPattern.FactoryMethodDesignPattern.PizzaStores.NyPizzaStore;
import FactoryDesignPattern.FactoryMethodDesignPattern.PizzaStores.PizzaStore;

public class Assembler {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore = new NyPizzaStore();
        nyPizzaStore.orderPizza("Cheese");

        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        chicagoPizzaStore.orderPizza("Veggie");
    }
}
