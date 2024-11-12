package StateDesignPattern.ATM;

import StateDesignPattern.ATM.State.State;
import StateDesignPattern.ATM.User.User;

public class Driver {
    public static void main(String[] args) {
        ATM atm = new ATM();
        State state = atm.getState();

        try {
            atm.getInventory().displayInventory();

            System.out.println("A User comes in");
            User user = new User("Joe", 4883, 5000);

            System.out.println("Entering the Card now");
            state.insertCard(atm);

            System.out.println("Entering the Pin");
            state = atm.getState();
            state.authenticatePin(atm, user, 4883);

            state = atm.getState();
            state.displayAccountBalance(atm, user);
            state.selectTransactionalOperation(atm, ATMOptions.WITHDRAWL);

            state = atm.getState();
            int rc = state.withdrawMoney(atm, user, 3000);
            if(rc != StatusCodes.WITHDRAWL_SUCCESSFUL) {
                System.out.println("Transaction Failed: " + rc);
            }

            atm.getInventory().displayInventory();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
