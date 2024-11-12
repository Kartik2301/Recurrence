package FactoryDesignPattern.PizzaIngredientsAcrossRegions;

public class Main {
    public static void main(String[] args) {
        AbstractIngredientFactory abstractIngredientFactory = new AbstractIngredientFactory();
        Assembler pizzaAssembler = new Assembler(abstractIngredientFactory);

        pizzaAssembler.preparePizza("NY");
    }
}
