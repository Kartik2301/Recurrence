package LLDQuestions.BookMyShow.Show;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import LLDQuestions.BookMyShow.Movie.Movie;
import LLDQuestions.BookMyShow.Seats.Seat;
import LLDQuestions.BookMyShow.Seats.SeatCategory;
import LLDQuestions.BookMyShow.Seats.SeatFactory;
import LLDQuestions.BookMyShow.Theater.Location;

public class Show {
    private Timestamp startTime;
    private Timestamp endTime;
    private Movie movie;
    private List<Seat> availableSeatsList;
    private Location location;

    public Show(Timestamp startTime, Timestamp endTime, Movie movie, int seatsCount, Location location) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.availableSeatsList = new ArrayList<>();
        this.location = location;

        initializeGrid(seatsCount);
    }

    public void initializeGrid(int seatsCount) {
        int seatId = 0;
        for(int i = 0; i < seatsCount / 3; i++) {
            Seat seat = SeatFactory.createSeat(SeatCategory.SILVER);
            seat.setSeatId(seatId++);
            this.availableSeatsList.add(seat);
        }

        for(int i = 0; i < seatsCount / 3; i++) {
            Seat seat = SeatFactory.createSeat(SeatCategory.GOLD);
            seat.setSeatId(seatId++);
            this.availableSeatsList.add(seat);
        }

        for(int i = 0; i < seatsCount / 3; i++) {
            Seat seat = SeatFactory.createSeat(SeatCategory.PLATINUM);
            seat.setSeatId(seatId++);
            this.availableSeatsList.add(seat);
        }
    }

    public Seat markSeatBooked(int seatID) {
        Seat seat = null;
        for(Seat tmpSeat: availableSeatsList) {
            if(tmpSeat.getSeatId() == seatID) {
                seat = tmpSeat;
                break;
            }
        }

        if(seat == null) {
            return null;
        }

        seat.setOccupied(true);
        availableSeatsList.remove(seat);
        return seat;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Seat> getAvailableSeatsList() {
        return availableSeatsList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

}
