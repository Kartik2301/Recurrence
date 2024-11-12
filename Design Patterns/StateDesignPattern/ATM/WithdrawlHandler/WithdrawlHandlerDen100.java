package StateDesignPattern.ATM.WithdrawlHandler;

import StateDesignPattern.ATM.StatusCodes;
import StateDesignPattern.ATM.Inventory.Currency;
import StateDesignPattern.ATM.Inventory.Inventory;

public class WithdrawlHandlerDen100 extends WithdrawlHandler {

    public WithdrawlHandlerDen100(WithdrawlHandler nexWithdrawlHandler) {
        super(nexWithdrawlHandler);
    }
    
    public int processWithdrawlRequest(Inventory inventory, int amountToWithdraw) {
        int count = 0;
        while(amountToWithdraw >= 100 && count < inventory.getDenominationUnitCount(Currency.note_100)) {
            count++;
            amountToWithdraw -= 100;
        }

        if(amountToWithdraw == 0 || super.processWithdrawlRequest(inventory, amountToWithdraw) == StatusCodes.WITHDRAWL_SUCCESSFUL) {
            inventory.updateInventory(Currency.note_100, count);
            System.out.println("Rs. 100 notes: " + count);
            return StatusCodes.WITHDRAWL_SUCCESSFUL;
        }
        return StatusCodes.MACHINE_INADEQUATE_FUNDS;
    }

}
