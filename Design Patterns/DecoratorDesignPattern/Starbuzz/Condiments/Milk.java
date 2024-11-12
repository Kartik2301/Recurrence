package DecoratorDesignPattern.Starbuzz.Condiments;

import DecoratorDesignPattern.Starbuzz.Coffee.Beverage;
import DecoratorDesignPattern.Starbuzz.Coffee.ServeSize;

public class Milk extends BeverageCondiment {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        int cost = beverage.getCost();
        if(beverage.getSize() == ServeSize.TALL) {
            cost += 5;
        } else if(beverage.getSize() == ServeSize.GALLANT) {
            cost += 10;
        } else {
            cost += 15;
        }
        return cost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public ServeSize getSize() {
        return beverage.getSize();
    }
    
}
