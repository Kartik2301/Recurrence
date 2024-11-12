package LLDQuestions.MovieTicketBooking.Shows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import LLDQuestions.MovieTicketBooking.Movie.Movie;
import LLDQuestions.MovieTicketBooking.Screen.Screen;
import LLDQuestions.MovieTicketBooking.Seats.Seat;

public class Show {
    private int showID;
    private int showStartingTime;
    private Movie movie;
    private Screen screen;
    private Set<Seat> bookedSeats;

    public Show(int showID, int showStartingTime, Movie movie, Screen screen) {
        this.showID = showID;
        this.showStartingTime = showStartingTime;
        this.movie = movie;
        this.screen = screen;
        this.bookedSeats = new HashSet<>();
    }

    public int getShowID() {
        return showID;
    }
    public void setShowID(int showID) {
        this.showID = showID;
    }
    public int getShowStartingTime() {
        return showStartingTime;
    }
    public void setShowStartingTime(int showStartingTime) {
        this.showStartingTime = showStartingTime;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public Screen getScreen() {
        return screen;
    }
    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public boolean bookSeat(Seat seat) {
        if(bookedSeats.contains(seat) == true) {
            return false;
        }
        
        if(screen.reserveSeat(seat) == true) {
            bookedSeats.add(seat);
            return true;
        }
        
        return false;
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();

        for(Seat seat: screen.getSeats()) {
            if(bookedSeats.contains(seat) == false) {
                availableSeats.add(seat);
            }
        }

        return availableSeats;
    }

}
