package TemplateMethodDesignPattern;

public class Client {
    public static void main(String[] args) {
        PaymentHandler handler = new PayToMerchant();
        handler.sendMoney();
    }
}
