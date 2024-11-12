package StateDesignPattern.ATM.State;

import StateDesignPattern.ATM.ATM;
import StateDesignPattern.ATM.ATMOptions;
import StateDesignPattern.ATM.User.User;

public interface State {
    public void insertCard(ATM atm) throws Exception;
    public boolean authenticatePin(ATM atm, User user, int pin) throws Exception;
    public void selectTransactionalOperation(ATM atm, ATMOptions atmOptions) throws Exception;
    public int withdrawMoney(ATM atm, User user, int amount) throws Exception;
    public void displayAccountBalance(ATM atm, User user) throws Exception;
}
