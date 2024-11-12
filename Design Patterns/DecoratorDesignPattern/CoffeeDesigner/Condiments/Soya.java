package DecoratorDesignPattern.CoffeeDesigner.Condiments;

import DecoratorDesignPattern.CoffeeDesigner.Beverages.Beverage;

public class Soya extends Condiment {

    Beverage beverage;

    public Soya(Beverage beverage) {
        this.beverage = beverage;
    }
    @Override
    public int cost() {
        return beverage.cost() + 10;
    }
}
