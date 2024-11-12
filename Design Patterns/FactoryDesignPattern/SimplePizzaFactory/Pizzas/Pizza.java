package FactoryDesignPattern.SimplePizzaFactory.Pizzas;

public abstract class Pizza {
    protected String name;

    public abstract int getCost();
    public abstract String getDescription();

    public void prepare() {
        System.out.println("Preparing a " + name + " Pizza ");
        System.out.println("Adding Sauce");
        System.out.println("Adding Toppings");
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
