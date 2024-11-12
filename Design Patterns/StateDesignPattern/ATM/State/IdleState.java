package StateDesignPattern.ATM.State;

import StateDesignPattern.ATM.ATM;
import StateDesignPattern.ATM.ATMOptions;
import StateDesignPattern.ATM.User.User;

public class IdleState implements State {

    public IdleState() {
        System.out.println("The machine is in the Idle State");
    }

    @Override
    public void insertCard(ATM atm) throws Exception {
        System.out.println("Insert your card, now.");
        atm.setState(new HasCardState());
    }

    @Override
    public boolean authenticatePin(ATM atm, User user, int pin) throws Exception {
        throw new UnsupportedOperationException("First Insert the card");
    }

    @Override
    public void selectTransactionalOperation(ATM atm, ATMOptions atmOptions) throws Exception {
        throw new UnsupportedOperationException("You Cannot select operation in the Idle State");
    }

    @Override
    public int withdrawMoney(ATM atm, User user, int amount) throws Exception {
        throw new UnsupportedOperationException("You cannot withdraw money in the Idle State");
    }

    @Override
    public void displayAccountBalance(ATM atm, User user) throws Exception {
        throw new UnsupportedOperationException("First you need to insert card");
    }
    
}
