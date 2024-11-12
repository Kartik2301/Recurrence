package DecoratorDesignPattern.Starbuzz.Condiments;

import DecoratorDesignPattern.Starbuzz.Coffee.ServeSize;

public class Soy extends BeverageCondiment {

    public Soy(BeverageCondiment beverage) {
        super(beverage);
    }

    @Override
    public int getCost() {
        int cost = beverage.getCost();
        if(beverage.getSize() == ServeSize.TALL) {
            cost += 15;
        } else if(beverage.getSize() == ServeSize.GALLANT) {
            cost += 25;
        } else {
            cost += 35;
        }
        return cost;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public ServeSize getSize() {
        return beverage.getSize();
    }
    
}
