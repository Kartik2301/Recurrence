package StateDesignPattern.ATM.State;

import StateDesignPattern.ATM.ATM;
import StateDesignPattern.ATM.ATMOptions;
import StateDesignPattern.ATM.User.User;

public class PerformOperation implements State {

    public PerformOperation(ATMOptions atmOptions) {
        System.out.println("The machine is in the PerformOperation State");
    }

    @Override
    public void insertCard(ATM atm) throws Exception {
        throw new UnsupportedOperationException("Invalid operation in the PerformOperation state");
    }

    @Override
    public boolean authenticatePin(ATM atm, User user, int pin) throws Exception {
        throw new UnsupportedOperationException("Invalid operation in the PerformOperation state");
    }

    @Override
    public void selectTransactionalOperation(ATM atm, ATMOptions atmOptions) throws Exception {
        throw new UnsupportedOperationException("Invalid operation in the PerformOperation state");
    }

    @Override
    public int withdrawMoney(ATM atm, User user, int amount) throws Exception {
        int rc =  atm.getInventory().withdrawMoney(amount, user);
        atm.setState(new IdleState());
        return rc;
    }

    @Override
    public void displayAccountBalance(ATM atm, User user) throws Exception {
        throw new UnsupportedOperationException("You cannot check account balance in Perform Operation state");
    }
    
}
