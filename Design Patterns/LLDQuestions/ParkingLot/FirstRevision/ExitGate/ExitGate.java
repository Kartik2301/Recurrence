package LLDQuestions.ParkingLot.FirstRevision.ExitGate;

import LLDQuestions.ParkingLot.FirstRevision.ExitGate.CostComputation.CostComputation;
import LLDQuestions.ParkingLot.FirstRevision.ExitGate.CostComputation.CostComputationFactory;
import LLDQuestions.ParkingLot.FirstRevision.Slots.ParkingSlotManagers.ParkingSlotManager;
import LLDQuestions.ParkingLot.FirstRevision.Slots.ParkingSlotManagers.ParkingSlotManagerFactory;
import LLDQuestions.ParkingLot.FirstRevision.Ticket.Ticket;

public class ExitGate {
    ParkingSlotManagerFactory parkingSlotManagerFactory;
    ParkingSlotManager parkingSlotManager;
    CostComputationFactory costComputationFactory;
    CostComputation costComputation;

    public ExitGate(ParkingSlotManagerFactory parkingSlotManagerFactory, CostComputationFactory costComputationFactory) {
        this.parkingSlotManagerFactory = parkingSlotManagerFactory;
        this.costComputationFactory = costComputationFactory;
    }

    private int computeCost(Ticket ticket) {
        costComputation = costComputationFactory.createCostComputation(ticket);
        return costComputation.computeCost(ticket);
    }

    public int releaseParkingSlot(Ticket ticket) {
        int parkingCharges = computeCost(ticket);

        // free the parking slot
        parkingSlotManager = parkingSlotManagerFactory.createParkingSlot(ticket.getVehicle());
        parkingSlotManager.removeVehicle(ticket.getParkingSlot());

        return parkingCharges;
    }
}
