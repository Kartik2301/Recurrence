package DecoratorDesignPattern.CustomPizzaDesigner.Toppings;

import DecoratorDesignPattern.CustomPizzaDesigner.Pizza.Pizza;

public class Cheese extends ToppingsDecorator {

    public Cheese(Pizza pizza) {
        super(pizza);
        super.addDescription(new StringBuilder("Cheese - ").append(pizza.getDescription()).toString());
    }

    @Override
    public int cost() {
        return pizza.cost() + 50;
    }
    
}
