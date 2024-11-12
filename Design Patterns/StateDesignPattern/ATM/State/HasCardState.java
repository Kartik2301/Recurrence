package StateDesignPattern.ATM.State;

import StateDesignPattern.ATM.ATM;
import StateDesignPattern.ATM.ATMOptions;
import StateDesignPattern.ATM.User.User;

public class HasCardState implements State {

    public HasCardState() {
        System.out.println("Machine is in the HasCard state");
    }

    @Override
    public void insertCard(ATM atm) throws Exception {
        return;
    }

    @Override
    public boolean authenticatePin(ATM atm, User user, int pin) throws Exception {
        if(pin == user.getUserPin()) {
            System.out.println("PIN Successfully Authenticated");
            atm.setState(new OperationSelectionState());
            return true;
        } 
        throw new Exception("Entered PIN is incorrect");
    }

    @Override
    public void selectTransactionalOperation(ATM atm, ATMOptions atmOptions) throws Exception {
        throw new UnsupportedOperationException("You Cannot select operation at HasCard state");
    }

    @Override
    public int withdrawMoney(ATM atm, User user, int amount) throws Exception {
        throw new UnsupportedOperationException("You Cannot withdraw money in the HasCard state");
    }

    @Override
    public void displayAccountBalance(ATM atm, User user) throws Exception {
        throw new UnsupportedOperationException("You cannot see account balance in the HasCard State");
    }
    
}
