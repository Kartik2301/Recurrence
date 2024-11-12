package ChainOfResponsibilityDesignPattern.ATM;

public abstract class WithdrawHandler {
    WithdrawHandler nexWithdrawHandler;

    public WithdrawHandler(WithdrawHandler nexWithdrawHandler) {
        this.nexWithdrawHandler = nexWithdrawHandler;
    }

    public void processWithdrawRequest(int amount) {
        if(nexWithdrawHandler != null) {
            nexWithdrawHandler.processWithdrawRequest(amount);
        }
    }
}
