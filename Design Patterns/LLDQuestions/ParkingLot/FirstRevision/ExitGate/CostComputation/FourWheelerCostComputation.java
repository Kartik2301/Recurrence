package LLDQuestions.ParkingLot.FirstRevision.ExitGate.CostComputation;

import LLDQuestions.ParkingLot.FirstRevision.PricingStrategies.MinutePricingStrategy;

public class FourWheelerCostComputation extends CostComputation {

    FourWheelerCostComputation() {
        super(new MinutePricingStrategy());
    }
    
}
