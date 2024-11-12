package StateDesignPattern.GumballMachine.GumballMachineStates;

import StateDesignPattern.GumballMachine.GumballMachine;

public class NoQuarterState implements GumballMachineState {

    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("Quarter Accepted");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("You cannot get a quarter if you have not inserted one");
    }

    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("You cannot turn the crank before inserting a quarter");
    }

    @Override
    public void dispense(GumballMachine gumballMachine) {
        System.out.println("Gumball cannot be dispensed before a quarter is inserted");
    }
    
}
