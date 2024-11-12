package LLDQuestions.BookMyShow.Booking;

import java.sql.Timestamp;

import LLDQuestions.BookMyShow.User;
import LLDQuestions.BookMyShow.Seats.Seat;
import LLDQuestions.BookMyShow.Show.Show;

public class Booking {
    private Show show;
    private Seat seat;
    private Timestamp createdAt;
    private User user;

    public Booking(Show show, Seat seat, User user) {
        this.show = show;
        this.seat = seat;
        this.user = user;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public Show getShow() {
        return show;
    }
    public void setShow(Show show) {
        this.show = show;
    }
    public Seat getSeat() {
        return seat;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public User getUser() {
        return user;
    }
}
