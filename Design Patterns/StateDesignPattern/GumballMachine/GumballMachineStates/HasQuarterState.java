package StateDesignPattern.GumballMachine.GumballMachineStates;

import java.util.Random;

import StateDesignPattern.GumballMachine.GumballMachine;

public class HasQuarterState implements GumballMachineState {
    private Random winner = new Random(System.currentTimeMillis());

    @Override
    public void insertQuarter(GumballMachine gumballMachine) {
        System.out.println("You have already inserted a quarter");
    }

    @Override
    public void ejectQuarter(GumballMachine gumballMachine) {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank(GumballMachine gumballMachine) {
        System.out.println("You turned the crank");
        int isWinner = winner.nextInt(10);
        if(isWinner == 0 && gumballMachine.getGumballCount() >= 2) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
        
    }

    @Override
    public void dispense(GumballMachine gumballMachine) {
        System.out.println("Gumball cannot be dispensed before the crank is turned");
    }
    
}
