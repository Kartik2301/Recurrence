package LLDQuestions.BookMyShow.Payment;

public class PaymentFactory {
    public static Payment createPaymentMethod(PaymentMethod paymentMethod) {
        Payment payment = null;

        switch (paymentMethod) {
            case UPI:
                payment = new Payment(new PayViaUPIStrategy());
                break;
            case ONARRIVAL:
                payment = new Payment(new PayOnArrival());
                break;
            case NETBANKING:
                payment = new Payment(new PayViaNetBanking());
                break;
        }

        return payment;
    }
}
