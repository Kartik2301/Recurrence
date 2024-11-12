package StateDesignPattern.ATM;

import StateDesignPattern.ATM.Inventory.Inventory;
import StateDesignPattern.ATM.State.IdleState;
import StateDesignPattern.ATM.State.State;

public class ATM {
    private State state;
    private Inventory inventory;

    public ATM() {
        state = new IdleState();
        inventory = new Inventory();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
