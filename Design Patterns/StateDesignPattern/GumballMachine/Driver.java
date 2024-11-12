package StateDesignPattern.GumballMachine;

import java.rmi.Naming;

public class Driver {
    public static void main(String[] args) {
        GumballMachine machine = new GumballMachine(15);
        System.out.println(machine);

        for(int customer = 1; customer <= 20; customer++) {
            System.out.println();
            System.out.println("Processing customer: " + customer);
            machine.insertQuarter();
            machine.turnCrank();
        }
    }
}
