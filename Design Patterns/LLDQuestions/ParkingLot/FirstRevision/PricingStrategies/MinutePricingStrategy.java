package LLDQuestions.ParkingLot.FirstRevision.PricingStrategies;

import java.util.Calendar;

import LLDQuestions.ParkingLot.FirstRevision.Ticket.Ticket;

public class MinutePricingStrategy implements PricingStrategy {

    @Override
    public int price(Ticket ticket) {
        long differenceInMilliseconds = (Calendar.getInstance().getTimeInMillis()) - ticket.getCreatedAt();
        int differenceInMinutes = (int) (differenceInMilliseconds / (1000 * 60));
        return (differenceInMinutes + 1) * ticket.getParkingSlot().getSlotPrice();
    }
    
}
