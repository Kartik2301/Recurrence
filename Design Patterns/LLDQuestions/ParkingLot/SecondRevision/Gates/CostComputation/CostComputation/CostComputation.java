package LLDQuestions.ParkingLot.SecondRevision.Gates.CostComputation.CostComputation;

import LLDQuestions.ParkingLot.SecondRevision.Gates.CostComputation.PricingStrategy.PricingStrategy;
import LLDQuestions.ParkingLot.SecondRevision.Ticket.ParkingTicket;

public class CostComputation {
    private PricingStrategy pricingStrategy;

    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public int computeParkingCost(ParkingTicket ticket) {
        return pricingStrategy.computeCost(ticket);
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

}
