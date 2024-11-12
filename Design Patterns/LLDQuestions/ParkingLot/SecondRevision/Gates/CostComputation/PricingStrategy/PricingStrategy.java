package LLDQuestions.ParkingLot.SecondRevision.Gates.CostComputation.PricingStrategy;

import LLDQuestions.ParkingLot.SecondRevision.Ticket.ParkingTicket;

public interface PricingStrategy {
    public int computeCost(ParkingTicket ticket);
}
