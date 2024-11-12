package LLDQuestions.MovieTicketBooking;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.MovieTicketBooking.Seats.Seat;
import LLDQuestions.MovieTicketBooking.Shows.Show;

public class Booking {
    private int bookingID;
    private Show show;
    private List<Seat> bookedSeats;

    public Booking(Show show) {
        this.bookingID = 1;
        this.show = show;
        this.bookedSeats = new ArrayList<>();
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void addBookedSeats(Seat bookedSeat) {
        this.bookedSeats.add(bookedSeat);
    }

    public int computeBill() {
        int price = 0;
        for(Seat seat: bookedSeats) {
            price += seat.getPrice();
        }
        return price;
    }
    
}
