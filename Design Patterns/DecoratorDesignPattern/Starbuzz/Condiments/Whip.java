package DecoratorDesignPattern.Starbuzz.Condiments;

import DecoratorDesignPattern.Starbuzz.Coffee.Beverage;
import DecoratorDesignPattern.Starbuzz.Coffee.ServeSize;

public class Whip extends BeverageCondiment {

    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        int cost = beverage.getCost();
        if(beverage.getSize() == ServeSize.TALL) {
            cost += 3;
        } else if(beverage.getSize() == ServeSize.GALLANT) {
            cost += 5;
        } else {
            cost += 8;
        }
        return cost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
    
    @Override
    public ServeSize getSize() {
        return beverage.getSize();
    }
    
}
