package DecoratorDesignPattern.Starbuzz.Condiments;

import DecoratorDesignPattern.Starbuzz.Coffee.Beverage;
import DecoratorDesignPattern.Starbuzz.Coffee.ServeSize;

public class Mocha extends BeverageCondiment {

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        int cost = beverage.getCost();
        if(beverage.getSize() == ServeSize.TALL) {
            cost += 25;
        } else if(beverage.getSize() == ServeSize.GALLANT) {
            cost += 35;
        } else {
            cost += 45;
        }
        return cost;
    }
    
    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public ServeSize getSize() {
        return beverage.getSize();
    }
}
