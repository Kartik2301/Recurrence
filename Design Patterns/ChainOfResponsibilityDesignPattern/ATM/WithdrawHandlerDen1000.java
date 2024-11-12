package ChainOfResponsibilityDesignPattern.ATM;

public class WithdrawHandlerDen1000 extends WithdrawHandler  {
    private int currencyDen = 1000;

    public WithdrawHandlerDen1000(WithdrawHandler nexWithdrawHandler) {
        super(nexWithdrawHandler);
    }

    public void processWithdrawRequest(int amount) {
        int notes = 0;
        while(amount >= currencyDen) {
            notes++;
            amount -= currencyDen;
        }

        if(notes > 0) {
            System.out.println("Rs. 1000 notes, dispatched = " + notes);
        }

        if(amount > 0) {
            super.processWithdrawRequest(amount);
        }
    }
}
