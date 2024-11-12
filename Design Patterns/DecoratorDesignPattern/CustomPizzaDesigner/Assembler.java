package DecoratorDesignPattern.CustomPizzaDesigner;

import DecoratorDesignPattern.CustomPizzaDesigner.Pizza.Pizza;
import DecoratorDesignPattern.CustomPizzaDesigner.Pizza.VegLoadedPizza;
import DecoratorDesignPattern.CustomPizzaDesigner.Toppings.Capsicum;
import DecoratorDesignPattern.CustomPizzaDesigner.Toppings.Cheese;

public class Assembler {
    public static void main(String[] args) {
        Pizza pizza = new Capsicum(new Cheese(new VegLoadedPizza()));

        System.out.println(pizza.cost());
        System.out.println(pizza.getDescription());
    }
}
