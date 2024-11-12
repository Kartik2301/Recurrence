package ChainOfResponsibilityDesignPattern.ATM;

public class WithdrawHandlerDen500 extends WithdrawHandler {
    private int currencyDen = 500;

    public WithdrawHandlerDen500(WithdrawHandler nexWithdrawHandler) {
        super(nexWithdrawHandler);
    }

    public void processWithdrawRequest(int amount) {
        int notes = 0;
        while(amount >= currencyDen) {
            notes++;
            amount -= currencyDen;
        }

        if(notes > 0) {
            System.out.println("Rs. 500 notes, dispatched = " + notes);
        }

        if(amount > 0) {
            super.processWithdrawRequest(amount);
        }
    }
}
