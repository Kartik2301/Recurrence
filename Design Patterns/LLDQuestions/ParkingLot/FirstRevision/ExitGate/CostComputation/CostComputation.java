package LLDQuestions.ParkingLot.FirstRevision.ExitGate.CostComputation;

import LLDQuestions.ParkingLot.FirstRevision.PricingStrategies.PricingStrategy;
import LLDQuestions.ParkingLot.FirstRevision.Ticket.Ticket;

public abstract class CostComputation {
    PricingStrategy pricingStrategy;

    CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public int computeCost(Ticket ticket) {
        return pricingStrategy.price(ticket);
    }
}
