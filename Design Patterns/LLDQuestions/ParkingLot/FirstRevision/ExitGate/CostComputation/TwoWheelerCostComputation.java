package LLDQuestions.ParkingLot.FirstRevision.ExitGate.CostComputation;

import LLDQuestions.ParkingLot.FirstRevision.PricingStrategies.SecondsPricingStrategy;

public class TwoWheelerCostComputation extends CostComputation {

    TwoWheelerCostComputation() {
        super(new SecondsPricingStrategy());
    }
    
}
