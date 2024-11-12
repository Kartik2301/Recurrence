package FactoryDesignPattern.PizzaIngredientsAcrossRegions;

import FactoryDesignPattern.PizzaIngredientsAcrossRegions.IngredientFactory.ChicagoStyleIngredientFactory;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.IngredientFactory.IngredientFactory;
import FactoryDesignPattern.PizzaIngredientsAcrossRegions.IngredientFactory.NyStyleIngredientFactory;

public class AbstractIngredientFactory {
    public IngredientFactory getIngredientFactory(String type) {
        if(type.equals("NY")) {
            return new NyStyleIngredientFactory();
        } else if(type.equals("Chicago")) {
            return new ChicagoStyleIngredientFactory();
        }

        return null;
    }
}
