package LLDQuestions.BookMyShow.Payment;

public class PayViaUPIStrategy implements PaymentStrategy {

    @Override
    public void makePayment(int amount) {
        System.out.println("Payment Made via UPI");
    }
    
}
