package DecoratorDesignPattern.Starbuzz;

import DecoratorDesignPattern.Starbuzz.Coffee.Beverage;
import DecoratorDesignPattern.Starbuzz.Coffee.DarkRoast;
import DecoratorDesignPattern.Starbuzz.Coffee.ServeSize;
import DecoratorDesignPattern.Starbuzz.Condiments.Milk;
import DecoratorDesignPattern.Starbuzz.Condiments.Mocha;
import DecoratorDesignPattern.Starbuzz.Condiments.Whip;

public class BeverageAssembler {
    public static void main(String[] args) {
        Beverage darkRoast = new DarkRoast();
        darkRoast.setSize(ServeSize.DAM);
        Beverage coffee = new Whip(new Milk(new Mocha(darkRoast)));

        System.out.println("Cost is: " + coffee.getCost());
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Size of the Beverage: " + coffee.getSize());
    }
}
