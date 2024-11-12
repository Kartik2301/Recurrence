package FactoryDesignPattern.SimplePizzaFactory.Pizzas;

public class CornPizza extends Pizza {

    public CornPizza() {
        name = "Corn";
    }

    @Override
    public int getCost() {
        return 175;
    }

    @Override
    public String getDescription() {
        return "Pizza with golden corn";
    }

    @Override
    public void box() {
        System.out.println("Bake at 30 degree Celsius for 45 mins");
    }
    
}
