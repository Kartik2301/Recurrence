package TemplateMethodDesignPattern;

public class PayToFriend extends PaymentHandler {

    @Override
    protected void debitMoney() {
        System.out.println("Rs. 100 deducted from user's account");
    }

    @Override
    protected void deductPlatformFee() {
        System.out.println("Platform fees is 0%");
    }

    @Override
    protected void creditMoney() {
        System.out.println("Rs. 100 credited to user's account");
    }
    
}
