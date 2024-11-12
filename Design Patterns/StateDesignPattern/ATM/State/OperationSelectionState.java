package StateDesignPattern.ATM.State;

import StateDesignPattern.ATM.ATM;
import StateDesignPattern.ATM.ATMOptions;
import StateDesignPattern.ATM.User.User;

public class OperationSelectionState implements State {

    public OperationSelectionState() {
        System.out.println("The machine is in the OperationSelection State");
    }

    @Override
    public void insertCard(ATM atm) throws Exception {
        throw new UnsupportedOperationException("Card cannot be inserted in the Operation Selection State");
    }

    @Override
    public boolean authenticatePin(ATM atm, User user, int pin) throws Exception {
        throw new UnsupportedOperationException("Pin has already been authenticated.");
    }

    @Override
    public void selectTransactionalOperation(ATM atm, ATMOptions atmOptions) throws Exception {
        atm.setState(new PerformOperation(atmOptions));
    }

    @Override
    public int withdrawMoney(ATM atm, User user, int amount) throws Exception {
        throw new UnsupportedOperationException("First Select the Operation");
    }

    @Override
    public void displayAccountBalance(ATM atm, User user) throws Exception {
        int balance = atm.getInventory().getUserAccountBalance(user);
        System.out.println("Your Account Balance is: Rs. " + balance);
    }
    
}
