package StateDesignPattern.GumballMachine.GumballMachineStates;

import StateDesignPattern.GumballMachine.GumballMachine;

public class SoldOutState implements GumballMachineState {

    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("Cannot Insert a quarter, machine is sold out");
    }

    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("Cannot eject a quarter, if you haven't inserted one");
    }

    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("Cannot turn the crank, machine is sold out");
    }

    @Override
    public void dispense(GumballMachine gumballMachine) {
        System.out.println("Cannot dispense, machine is sold out");
    }
    
}
