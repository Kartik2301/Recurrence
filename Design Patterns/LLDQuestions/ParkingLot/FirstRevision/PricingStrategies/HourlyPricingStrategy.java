package LLDQuestions.ParkingLot.FirstRevision.PricingStrategies;

import java.util.Calendar;

import LLDQuestions.ParkingLot.FirstRevision.Ticket.Ticket;

public class HourlyPricingStrategy implements PricingStrategy {

    @Override
    public int price(Ticket ticket) {
        long differenceInMilliseconds = (Calendar.getInstance().getTimeInMillis()) - ticket.getCreatedAt();
        int differenceInHours = (int) (differenceInMilliseconds / (1000 * 3600));
        return (differenceInHours + 2) * ticket.getParkingSlot().getSlotPrice();
    }
    
}
