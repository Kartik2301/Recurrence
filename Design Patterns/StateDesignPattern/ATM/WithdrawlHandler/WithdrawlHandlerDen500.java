package StateDesignPattern.ATM.WithdrawlHandler;

import StateDesignPattern.ATM.StatusCodes;
import StateDesignPattern.ATM.Inventory.Currency;
import StateDesignPattern.ATM.Inventory.Inventory;

public class WithdrawlHandlerDen500 extends WithdrawlHandler {

    public WithdrawlHandlerDen500(WithdrawlHandler nexWithdrawlHandler) {
        super(nexWithdrawlHandler);
    }

    public int processWithdrawlRequest(Inventory inventory, int amountToWithdraw) {
        int count = 0;
        while(amountToWithdraw >= 500  && count < inventory.getDenominationUnitCount(Currency.note_500)) {
            count++;
            amountToWithdraw -= 500;
        }
        if(amountToWithdraw == 0 || super.processWithdrawlRequest(inventory, amountToWithdraw) == StatusCodes.WITHDRAWL_SUCCESSFUL) {
            inventory.updateInventory(Currency.note_500, count);
            System.out.println("Rs. 500 notes: " + count);
            return StatusCodes.WITHDRAWL_SUCCESSFUL;
        }
        return StatusCodes.MACHINE_INADEQUATE_FUNDS;
    }
    
}
