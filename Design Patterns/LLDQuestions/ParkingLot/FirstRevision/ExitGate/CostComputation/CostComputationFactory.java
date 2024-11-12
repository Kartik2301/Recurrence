package LLDQuestions.ParkingLot.FirstRevision.ExitGate.CostComputation;

import LLDQuestions.ParkingLot.FirstRevision.Ticket.Ticket;

public class CostComputationFactory {
    public CostComputation createCostComputation(Ticket ticket) {
        switch (ticket.getVehicle().getVehicleType()) {
            case TwoWheeler:
                return new TwoWheelerCostComputation();

            case FourWheeler:
                return new FourWheelerCostComputation();
        
            default:
                return null;
        }
    }
}
