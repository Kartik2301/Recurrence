package StateDesignPattern.GumballMachine;

import StateDesignPattern.GumballMachine.GumballMachineStates.GumballMachineState;
import StateDesignPattern.GumballMachine.GumballMachineStates.HasQuarterState;
import StateDesignPattern.GumballMachine.GumballMachineStates.NoQuarterState;
import StateDesignPattern.GumballMachine.GumballMachineStates.SoldOutState;
import StateDesignPattern.GumballMachine.GumballMachineStates.SoldState;
import StateDesignPattern.GumballMachine.GumballMachineStates.WinnerState;

public class GumballMachine {
    private GumballMachineState noQuarterState;
    private GumballMachineState hasQuarterState;
    private GumballMachineState soldState;
    private GumballMachineState soldOutState;
    private GumballMachineState winnerState;

    private GumballMachineState state;
    private int gumballCount;


    public GumballMachine(int count) {
        noQuarterState = new NoQuarterState();
        hasQuarterState = new HasQuarterState();
        soldState = new SoldState();
        soldOutState = new SoldOutState();
        winnerState = new WinnerState();
        
        gumballCount = count;
        if(count > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter(this);
    }

    public void ejectQuarter() {
        state.ejectQuarter(this);
    }

    public void turnCrank() {
        state.turnCrank(this);
        state.dispense(this);
    }

    public GumballMachineState getNoQuarterState() {
        return noQuarterState;
    }

    public GumballMachineState getHasQuarterState() {
        return hasQuarterState;
    }

    public GumballMachineState getSoldState() {
        return soldState;
    }

    public GumballMachineState getSoldOutState() {
        return soldOutState;
    }

    public GumballMachineState getWinnerState() {
        return winnerState;
    }

    public int getGumballCount() {
        return gumballCount;
    }

    public void setState(GumballMachineState state) {
        this.state = state;
    }

    public void releaseBall() {
        System.out.println("A Gumball comes rolling out");
        this.gumballCount--;
    }

    @Override
    public String toString() {
        return "Gumball Machine - 2024, state: " + state.getClass().getSimpleName();
    }

}
