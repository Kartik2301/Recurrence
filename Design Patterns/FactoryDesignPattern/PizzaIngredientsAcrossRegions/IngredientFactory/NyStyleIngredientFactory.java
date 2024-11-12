package FactoryDesignPattern.PizzaIngredientsAcrossRegions.IngredientFactory;

import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Cheese.Cheese;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Cheese.Parmesan;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Crust.Crust;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Crust.ThinCrust;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Sauce.PlumTomato;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.PizzaIngredients.Sauce.Sauce;

public class NyStyleIngredientFactory implements IngredientFactory {

    @Override
    public Cheese getCheese() {
        return new Parmesan();
    }

    @Override
    public Sauce getSauce() {
        return new PlumTomato();
    }

    @Override
    public Crust getCrust() {
        return new ThinCrust();
    }
    
}
