package LLDQuestions.ParkingLot.SecondRevision.Gates.CostComputation.PricingStrategy;

import LLDQuestions.ParkingLot.SecondRevision.Ticket.ParkingTicket;

public class HourlyBasedPricingStrategy implements PricingStrategy {

    @Override
    public int computeCost(ParkingTicket ticket) {
        return 50;
    }
    
}
