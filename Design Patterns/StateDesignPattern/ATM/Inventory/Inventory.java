package StateDesignPattern.ATM.Inventory;

import java.util.HashMap;
import java.util.Map;

import StateDesignPattern.ATM.StatusCodes;
import StateDesignPattern.ATM.User.User;
import StateDesignPattern.ATM.WithdrawlHandler.WithdrawlHandler;
import StateDesignPattern.ATM.WithdrawlHandler.WithdrawlHandlerDen100;
import StateDesignPattern.ATM.WithdrawlHandler.WithdrawlHandlerDen2000;
import StateDesignPattern.ATM.WithdrawlHandler.WithdrawlHandlerDen500;

public class Inventory {
    private Map<Currency, Integer> denominations;
    private WithdrawlHandler withdrawlHandler;

    public Inventory() {
        denominations = new HashMap<>();
        denominations.put(Currency.note_2000, 5);
        denominations.put(Currency.note_500, 5);
        denominations.put(Currency.note_100, 5);

        withdrawlHandler = new WithdrawlHandlerDen2000(new WithdrawlHandlerDen500(new WithdrawlHandlerDen100(null)));
    }

    public void addDenominationUnits(Currency currency, int units) {
        denominations.put(currency, denominations.getOrDefault(currency, 0) + units);
    }

    public int withdrawMoney(int withdrawMoneyAmount, User user) {
        if(user.getAccountBalance() < withdrawMoneyAmount) return StatusCodes.INSUFFICIENT_ACCOUNT_BALANCE;

        int rc = withdrawlHandler.processWithdrawlRequest(this, withdrawMoneyAmount);
        if(rc == StatusCodes.WITHDRAWL_SUCCESSFUL) {
            user.setAccountBalance(withdrawMoneyAmount);
            System.out.println("Transaction Successful, your account balance is: Rs. " + user.getAccountBalance());
        }
        return rc;
    }

    public int getUserAccountBalance(User user) {
        return user.getAccountBalance();
    }

    public int getDenominationUnitCount(Currency currency) {
        return denominations.get(currency);
    }

    public void updateInventory(Currency currency, int noteCountDelta) {
        denominations.put(currency, denominations.get(currency) - noteCountDelta);
    }

    public void displayInventory() {
        System.out.println("Number of notes of denomination Rs. 2000 present currently: " + denominations.get(Currency.note_2000));
        System.out.println("Number of notes of denomination Rs. 500 present currently: " + denominations.get(Currency.note_500));
        System.out.println("Number of notes of denomination Rs. 100 present currently: " + denominations.get(Currency.note_100));
    }
}
