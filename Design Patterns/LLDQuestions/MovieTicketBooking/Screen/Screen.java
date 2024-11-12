package LLDQuestions.MovieTicketBooking.Screen;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.MovieTicketBooking.SeatCategory;
import LLDQuestions.MovieTicketBooking.Seats.Seat;

public class Screen {
    private int screenID;
    private List<Seat> seats;

    public Screen(int screenID, List<Seat> seats) {
        this.screenID = screenID;
        this.seats = new ArrayList<>();
    }

    public int getScreenID() {
        return screenID;
    }

    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public void setUpSeats() {
        for(int i = 0; i < 30; i++) {
            Seat seat = new Seat(i + 1, i + 1, SeatCategory.SILVER, 100);
            seats.add(seat);
        }

        for(int i = 30; i < 60; i++) {
            Seat seat = new Seat(i + 1, i + 1, SeatCategory.GOLD, 200);
            seats.add(seat);
        }

        for(int i = 60; i < 100; i++) {
            Seat seat = new Seat(i + 1, i + 1, SeatCategory.PLATINUM, 400);
            seats.add(seat);
        }
    }

    public boolean reserveSeat(Seat seat) {
        if(seat.getSeatID() < 1 || seat.getSeatID() > 100) {
            return false;
        }
        seat.setReserved(true);
        return true;
    }
    
}
