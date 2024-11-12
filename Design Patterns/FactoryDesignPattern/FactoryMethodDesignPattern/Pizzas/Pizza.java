package FactoryDesignPattern.FactoryMethodDesignPattern.Pizzas;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
    protected String name;
    protected String sauce;
    protected String crust;
    protected List<String> toppings = new ArrayList<>();
    

    public void prepare() {
        System.out.println("Preparing a " + name + " Pizza ");
        System.out.println("Adding Sauce: " + sauce);
        System.out.println("Adding Toppings");
        for(String topping: toppings) {
            System.out.println("\t" + topping);
        }
        System.out.println("Type of Crust: " + crust);
    }

    public void bake() {
        System.out.println("Bake at 100 degree Celsius for 30 mins");
    }

    public void cut() {
        System.out.println("Cut into 8 pieces");
    }

    public void box() {
        System.out.println("Package the pizza in the company certified box");
    } 
}
