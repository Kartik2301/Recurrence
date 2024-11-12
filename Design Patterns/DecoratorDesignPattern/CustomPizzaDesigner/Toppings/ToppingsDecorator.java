package DecoratorDesignPattern.CustomPizzaDesigner.Toppings;

import DecoratorDesignPattern.CustomPizzaDesigner.Pizza.Pizza;

public abstract class ToppingsDecorator extends Pizza {
    Pizza pizza;

    public ToppingsDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}
