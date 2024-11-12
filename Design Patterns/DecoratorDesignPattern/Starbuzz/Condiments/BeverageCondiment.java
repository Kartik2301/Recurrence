package DecoratorDesignPattern.Starbuzz.Condiments;

import DecoratorDesignPattern.Starbuzz.Coffee.Beverage;
import DecoratorDesignPattern.Starbuzz.Coffee.ServeSize;

public abstract class BeverageCondiment extends Beverage {
    protected Beverage beverage;

    public BeverageCondiment(Beverage beverage) {
        this.beverage = beverage;
    }

    public abstract String getDescription();
    public abstract ServeSize getSize();
}
