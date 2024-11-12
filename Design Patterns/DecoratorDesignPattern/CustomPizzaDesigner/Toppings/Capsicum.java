package DecoratorDesignPattern.CustomPizzaDesigner.Toppings;

import DecoratorDesignPattern.CustomPizzaDesigner.Pizza.Pizza;

public class Capsicum extends ToppingsDecorator {
    public Capsicum(Pizza pizza) {
        super(pizza);
        this.addDescription(new StringBuilder("Capsicum - ").append(pizza.getDescription()).toString());
    }

    @Override
    public int cost() {
        return pizza.cost() + 20;
    }
    
}
