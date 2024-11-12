package LLDQuestions.BookMyShow.Booking;

import LLDQuestions.BookMyShow.User;
import LLDQuestions.BookMyShow.Seats.Seat;
import LLDQuestions.BookMyShow.Show.Show;

public class BookingManager {
    private static BookingManager bookingManager;
    private BookingManager() {}
    public Booking makeBooking(Show show, Seat seat, User user) {
        return new Booking(show, seat, user);
    }

    public static BookingManager getInstance() {
        if(bookingManager == null) {
            bookingManager = new BookingManager();
        }
        return bookingManager;
    }

}
