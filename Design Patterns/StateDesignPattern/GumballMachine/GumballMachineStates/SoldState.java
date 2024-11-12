package StateDesignPattern.GumballMachine.GumballMachineStates;

import StateDesignPattern.GumballMachine.GumballMachine;

public class SoldState implements GumballMachineState {

    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("First let the transaction complete");
    }

    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("Gumball already dispensed, quarter cannot be ejected");
    }

    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("Turning crank again won't give you another gumball");
    }

    @Override
    public void dispense(GumballMachine gumballMachine) {
        gumballMachine.releaseBall();
        if(gumballMachine.getGumballCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
    
}
