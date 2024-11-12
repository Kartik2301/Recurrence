package DecoratorDesignPattern.CustomPizzaDesigner.Pizza;

public class GoldenCornPizza extends Pizza {

    public GoldenCornPizza() {
        super.addDescription("Golden Corn Pizza");
    }

    @Override
    public int cost() {
        return 400;
    }
    
}
