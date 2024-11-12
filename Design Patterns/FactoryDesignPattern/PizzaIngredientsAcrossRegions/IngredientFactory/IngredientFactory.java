package FactoryDesignPattern.PizzaIngredientsAcrossRegions.IngredientFactory;

import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Cheese.Cheese;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Crust.Crust;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Sauce.Sauce;

public interface IngredientFactory {
    public Cheese getCheese();
    public Sauce getSauce();
    public Crust getCrust();
}
 