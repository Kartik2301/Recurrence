package LLDQuestions.ParkingLot.FirstRevision.PricingStrategies;

import LLDQuestions.ParkingLot.FirstRevision.Ticket.Ticket;

public interface PricingStrategy {
    public int price(Ticket ticket);
}
