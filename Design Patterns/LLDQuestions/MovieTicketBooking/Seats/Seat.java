package LLDQuestions.MovieTicketBooking.Seats;

import LLDQuestions.MovieTicketBooking.SeatCategory;

public class Seat {
    private int seatID;
    private int seatNumber;
    private SeatCategory seatCategory;
    private int price;
    private boolean isReserved;

    public Seat(int seatID, int seatNumber, SeatCategory seatCategory, int price) {
        this.seatID = seatID;
        this.seatNumber = seatNumber;
        this.seatCategory = seatCategory;
        this.price = price;
        this.isReserved = false;
    }

    public int getSeatID() {
        return seatID;
    }

    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }
    
}
