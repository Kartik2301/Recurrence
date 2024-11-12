package TemplateMethodDesignPattern;

public class PayToMerchant extends PaymentHandler {

    @Override
    protected void debitMoney() {
        System.out.println("Rs. 100 + GST deducted from user's account, ");
    }

    @Override
    protected void deductPlatformFee() {
        System.out.println("Platform fees is 2%");
    }

    @Override
    protected void creditMoney() {
        System.out.println("Rs. 98 credited to Merchant's account");
    }
    
}
