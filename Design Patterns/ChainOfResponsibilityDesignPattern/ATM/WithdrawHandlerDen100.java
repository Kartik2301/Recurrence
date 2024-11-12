package ChainOfResponsibilityDesignPattern.ATM;

public class WithdrawHandlerDen100 extends WithdrawHandler {
    private int currencyDen = 100;

    public WithdrawHandlerDen100(WithdrawHandler nextWithdrawHandler) {
        super(nextWithdrawHandler);
    }

    public void processWithdrawRequest(int amount) {
        int notes = 0;
        while(amount >= currencyDen) {
            notes++;
            amount -= currencyDen;
        }

        if(notes > 0) {
            System.out.println("Rs. 100 notes, dispatched = " + notes);
        }

        if(amount > 0) {
            super.processWithdrawRequest(amount);
        }
    }
}
