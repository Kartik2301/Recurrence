package StateDesignPattern.ATM.WithdrawlHandler;

import StateDesignPattern.ATM.StatusCodes;
import StateDesignPattern.ATM.Inventory.Inventory;

public abstract class WithdrawlHandler {
    private WithdrawlHandler nextWithdrawlHandler;

    public WithdrawlHandler(WithdrawlHandler nextWithdrawlHandler) {
        this.nextWithdrawlHandler = nextWithdrawlHandler;
    }

    public int processWithdrawlRequest(Inventory inventory, int amountToWithdraw) {
        if(nextWithdrawlHandler != null) {
            return nextWithdrawlHandler.processWithdrawlRequest(inventory, amountToWithdraw);
        }
        return StatusCodes.MACHINE_INADEQUATE_FUNDS;
    }
}
