package DecoratorDesignPattern.CustomPizzaDesigner.Pizza;

public class HerbyPizza extends Pizza {

    public HerbyPizza() {
        super.addDescription("Herby Pizza");
    }

    @Override
    public int cost() {
        return 300;
    }
    
}
