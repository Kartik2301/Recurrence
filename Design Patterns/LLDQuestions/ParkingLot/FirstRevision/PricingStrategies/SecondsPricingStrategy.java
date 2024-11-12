package LLDQuestions.ParkingLot.FirstRevision.PricingStrategies;

import java.util.Calendar;

import LLDQuestions.ParkingLot.FirstRevision.Ticket.Ticket;

public class SecondsPricingStrategy implements PricingStrategy {

    @Override
    public int price(Ticket ticket) {
        long differenceInMilliseconds = (Calendar.getInstance().getTimeInMillis()) - ticket.getCreatedAt();
        int differenceInSeconds = (int) (differenceInMilliseconds / (1000));
        return (differenceInSeconds + 1) * ticket.getParkingSlot().getSlotPrice();
    }
    
}
