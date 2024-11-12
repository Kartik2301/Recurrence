package FactoryDesignPattern.PizzaIngredientsAcrossRegions.IngredientFactory;

import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Cheese.Cheese;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Cheese.Mozarella;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Crust.Crust;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Crust.ThickCrust;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Sauce.Marinara;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Sauce.Sauce;

public class ChicagoStyleIngredientFactory implements IngredientFactory {

    @Override
    public Cheese getCheese() {
        return new Mozarella();
    }

    @Override
    public Sauce getSauce() {
        return new Marinara();
    }

    @Override
    public Crust getCrust() {
        return new ThickCrust();
    }
    
}
