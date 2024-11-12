package StateDesignPattern.ATM.WithdrawlHandler;

import StateDesignPattern.ATM.StatusCodes;
import StateDesignPattern.ATM.Inventory.Currency;
import StateDesignPattern.ATM.Inventory.Inventory;

public class WithdrawlHandlerDen2000 extends WithdrawlHandler {

    public WithdrawlHandlerDen2000(WithdrawlHandler nextWithdrawlHandler) {
        super(nextWithdrawlHandler);
    }

    public int processWithdrawlRequest(Inventory inventory, int amountToWithdraw) {
        int count = 0;
        while(amountToWithdraw >= 2000 && count < inventory.getDenominationUnitCount(Currency.note_2000)) {
            count++;
            amountToWithdraw -= 2000;
        }

        if(amountToWithdraw == 0 || super.processWithdrawlRequest(inventory, amountToWithdraw) == StatusCodes.WITHDRAWL_SUCCESSFUL) {
            inventory.updateInventory(Currency.note_2000, count);
            System.out.println("Rs. 2000 notes: " + count);
            return StatusCodes.WITHDRAWL_SUCCESSFUL;
        }
        return StatusCodes.MACHINE_INADEQUATE_FUNDS;
    }
    
}
