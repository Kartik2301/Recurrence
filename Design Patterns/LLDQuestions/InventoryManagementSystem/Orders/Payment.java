package LLDQuestions.InventoryManagementSystem.Orders;

public class Payment {
    public static enum PaymentMode {
        UPI,
        CASH,
        CARD;
    }
    private PaymentMode paymentMode = PaymentMode.UPI;
}