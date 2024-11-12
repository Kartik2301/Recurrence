package LLDQuestions.BookMyShow.Payment;

public class PayViaNetBanking implements PaymentStrategy {

    @Override
    public void makePayment(int amount) {
        System.out.println("Payment Made via Net Banking");
    }
    
}
