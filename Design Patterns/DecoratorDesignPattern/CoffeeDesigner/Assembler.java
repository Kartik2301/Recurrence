package DecoratorDesignPattern.CoffeeDesigner;

import java.io.FilterInputStream;
import java.util.Scanner;

import DecoratorDesignPattern.CoffeeDesigner.Beverages.Beverage;
import DecoratorDesignPattern.CoffeeDesigner.Beverages.Decaf;
import DecoratorDesignPattern.CoffeeDesigner.Beverages.Espresso;
import DecoratorDesignPattern.CoffeeDesigner.Beverages.Latte;
import DecoratorDesignPattern.CoffeeDesigner.Condiments.Mocha;
import DecoratorDesignPattern.CoffeeDesigner.Condiments.Soya;

public class Assembler {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select the type of coffee");
        System.out.println("1 - Latte");
        System.out.println("2 - Decaf");
        System.out.println("3 - Espresso");
        System.out.println("4 - Dark Roast");

        int coffeeType = scanner.nextInt();

        Beverage beverage = new Soya(new Mocha(new Espresso()));

        switch (coffeeType) {
            case 1:
                beverage = new Latte();
                break;
            case 2:
                beverage = new Decaf();
                break;
            case 3:
                beverage = new Espresso();
                break;
            case 4:
                System.out.println("Stock finished");
                break;
            default:
                System.out.println("Can you atleast press a button correctly");
                break;
        }

        if(coffeeType >= 1 && coffeeType <= 3) {
            int choice = 0;
            System.out.println("Do you want soya [1/0]");
            choice = scanner.nextInt();
    
            if(choice == 1) {
                beverage = new Soya(beverage);
                choice = 0;
            }
            
            System.out.println("Do you want mocha [1/0]");
            choice = scanner.nextInt();
    
            if(choice == 1) {
                beverage = new Mocha(beverage);
                choice = 0;
            }
    
            System.out.println("Final cost of the beverage is: " + beverage.cost());

        } else {
            System.out.println("Your likes are not welcome here");
        }
    }
}
