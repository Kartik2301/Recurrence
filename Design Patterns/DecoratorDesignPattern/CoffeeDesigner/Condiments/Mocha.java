package DecoratorDesignPattern.CoffeeDesigner.Condiments;

import DecoratorDesignPattern.CoffeeDesigner.Beverages.Beverage;

public class Mocha extends Condiment {

    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 30;
    }
}
