package LLDQuestions.BookMyShow.Seats;

public class Seat {
    private int seatId;
    private SeatCategory seatCategory;
    private int seatCost;
    private boolean isOccupied;

    public Seat() { }

    public Seat(int seatId, SeatCategory seatCategory, int seatCost) {
        this.seatId = seatId;
        this.seatCategory = seatCategory;
        this.seatCost = seatCost;
    }

    public int getSeatId() {
        return seatId;
    }
    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
    public SeatCategory getSeatCategory() {
        return seatCategory;
    }
    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }
    public int getSeatCost() {
        return seatCost;
    }
    public void setSeatCost(int seatCost) {
        this.seatCost = seatCost;
    }
    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
  
}
