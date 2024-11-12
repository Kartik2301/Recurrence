package LLDQuestions.BookMyShow.Show;

import LLDQuestions.BookMyShow.User;
import LLDQuestions.BookMyShow.Booking.Booking;
import LLDQuestions.BookMyShow.Booking.BookingManager;
import LLDQuestions.BookMyShow.Payment.Payment;
import LLDQuestions.BookMyShow.Payment.PaymentFactory;
import LLDQuestions.BookMyShow.Payment.PaymentMethod;
import LLDQuestions.BookMyShow.Seats.Seat;

public class ShowController {
    private Show show;
    
    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
    
    public Booking makeBooking(User user, int seatId) {
        Seat seat = show.markSeatBooked(seatId);
        BookingManager manager = BookingManager.getInstance();
        Payment payment = PaymentFactory.createPaymentMethod(PaymentMethod.UPI);

        if(seat != null) {
            // Make Payment
            payment.makePayment(seat.getSeatCost());
            return manager.makeBooking(this.show, seat, user);
        }

        return null;
    } 
}
