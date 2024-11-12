package LLDQuestions.BookMyShow.Seats;

public class SeatFactory {
    public static Seat createSeat(SeatCategory seatCategory) {
        Seat seat = new Seat();
        seat.setOccupied(false);
        switch (seatCategory) {
            case SILVER:
                seat.setSeatCategory(SeatCategory.SILVER);
                seat.setSeatCost(200);
                break;
            case GOLD:
                seat.setSeatCategory(SeatCategory.GOLD);
                seat.setSeatCost(300);
                break;
            case PLATINUM:
                seat.setSeatCategory(SeatCategory.PLATINUM);
                seat.setSeatCost(500);
                break;
            default:
                break;
        }

        return seat;
    }
}
