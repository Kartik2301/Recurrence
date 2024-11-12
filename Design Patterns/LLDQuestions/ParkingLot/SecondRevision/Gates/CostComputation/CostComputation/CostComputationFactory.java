package LLDQuestions.ParkingLot.SecondRevision.Gates.CostComputation.CostComputation;

import LLDQuestions.ParkingLot.SecondRevision.Gates.CostComputation.PricingStrategy.HourlyBasedPricingStrategy;
import LLDQuestions.ParkingLot.SecondRevision.Gates.CostComputation.PricingStrategy.MinuteBasedPricingStrategy;
import LLDQuestions.ParkingLot.SecondRevision.Vehicles.VehicleType;

public class CostComputationFactory {
    public CostComputation getCostComputationInstance(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return new FourWheelerCostComputation(new HourlyBasedPricingStrategy());
            case BIKE:
                return new TwoWheelerCostComputation(new MinuteBasedPricingStrategy());
            default:
                break;
        }

        return null;
    }
}
