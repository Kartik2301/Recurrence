package DecoratorDesignPattern.CustomPizzaDesigner.Toppings;

import DecoratorDesignPattern.CustomPizzaDesigner.Pizza.Pizza;

public class Mushroom extends ToppingsDecorator {

    public Mushroom(Pizza pizza) {
        super(pizza);
        this.addDescription(new StringBuilder("Mushroom - ").append(pizza.getDescription()).toString());
    }

    @Override
    public int cost() {
        return pizza.cost() + 40;
    }
    
}
