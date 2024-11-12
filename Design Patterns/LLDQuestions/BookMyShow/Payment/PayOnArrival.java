package LLDQuestions.BookMyShow.Payment;

public class PayOnArrival implements PaymentStrategy {

    @Override
    public void makePayment(int amount) {
        System.out.println("Pay On Arrival");
    }
    
}
