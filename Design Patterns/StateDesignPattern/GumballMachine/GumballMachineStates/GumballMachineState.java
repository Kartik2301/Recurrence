package StateDesignPattern.GumballMachine.GumballMachineStates;

import StateDesignPattern.GumballMachine.GumballMachine;

public interface GumballMachineState {
    public void insertQuarter(GumballMachine gumballMachine);
    public void ejectQuarter(GumballMachine gumballMachine);
    public void turnCrank(GumballMachine gumballMachine);
    public void dispense(GumballMachine gumballMachine);
}
