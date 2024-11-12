package DecoratorDesignPattern.CustomPizzaDesigner.Pizza;

public class VegLoadedPizza extends Pizza {

    public VegLoadedPizza() {
        super.addDescription("Veg Loaded Pizza");
    }

    @Override
    public int cost() {
        return 500;
    }
    
}
