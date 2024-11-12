package FactoryDesignPattern.PizzaIngredientsAcrossRegions;

import FactoryDesignPattern.PizzaIngredientsAcrossRegions.IngredientFactory.IngredientFactory;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Cheese.Cheese;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Crust.Crust;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Sauce.Sauce;

public class Assembler {
    private Cheese cheese;
    private Sauce sauce;
    private Crust crust;
    private AbstractIngredientFactory factory;

    public Assembler(AbstractIngredientFactory factory) {
        this.factory =  factory;
    }

    public void preparePizza(String type) {
        IngredientFactory ingredientFactory = factory.getIngredientFactory(type);
        cheese = ingredientFactory.getCheese();
        sauce = ingredientFactory.getSauce();
        crust = ingredientFactory.getCrust();

        System.out.println(cheese.getName() + ", " + sauce.getName() +  ", " + crust.getName());
    }
}
