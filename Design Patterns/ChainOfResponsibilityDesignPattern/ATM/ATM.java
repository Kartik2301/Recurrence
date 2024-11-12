package ChainOfResponsibilityDesignPattern.ATM;

public class ATM {
    public static void main(String [] args) {
        WithdrawHandler withdrawHandler = new WithdrawHandlerDen1000(new WithdrawHandlerDen500(new WithdrawHandlerDen100(null)));
        withdrawHandler.processWithdrawRequest(2800);
    }
}
