package TemplateMethodDesignPattern;

public abstract class PaymentHandler {
    public final boolean sendMoney() {
        boolean isValid = validateRequest();

        if(!isValid) return false;

        debitMoney();

        deductPlatformFee();

        creditMoney();

        return true;
    }

    protected boolean validateRequest() {
        System.out.println("Request is Valid");
        return true;
    }

    protected abstract void debitMoney();
    protected abstract void deductPlatformFee();
    protected abstract void creditMoney();
}
