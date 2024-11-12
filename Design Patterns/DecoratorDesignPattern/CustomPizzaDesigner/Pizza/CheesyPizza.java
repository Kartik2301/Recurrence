package DecoratorDesignPattern.CustomPizzaDesigner.Pizza;

public class CheesyPizza extends Pizza {

    public CheesyPizza() {
        super.addDescription("Cheesy Pizza");
    }

    @Override
    public int cost() {
        return 400;
    }
    
}
