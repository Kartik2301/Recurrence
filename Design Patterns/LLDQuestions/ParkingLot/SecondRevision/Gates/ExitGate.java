package LLDQuestions.ParkingLot.SecondRevision.Gates;

import LLDQuestions.ParkingLot.SecondRevision.Gates.CostComputation.CostComputation.CostComputation;
import LLDQuestions.ParkingLot.SecondRevision.Gates.CostComputation.CostComputation.CostComputationFactory;
import LLDQuestions.ParkingLot.SecondRevision.ParkingSlotManager.ParkingSlotManager;
import LLDQuestions.ParkingLot.SecondRevision.ParkingSlotManager.ParkingSlotManagerFactory;
import LLDQuestions.ParkingLot.SecondRevision.Ticket.ParkingTicket;

public class ExitGate {
    private ParkingSlotManager parkingSlotManager;
    private ParkingSlotManagerFactory parkingSlotManagerFactory;
    private CostComputationFactory computationFactory;

    public ExitGate(ParkingSlotManagerFactory parkingSlotManagerFactory, CostComputationFactory computationFactory) {
        this.parkingSlotManagerFactory = parkingSlotManagerFactory;
        this.computationFactory = computationFactory;
    }

    public void freeUpParkingSlot(ParkingTicket ticket) {
        parkingSlotManager = parkingSlotManagerFactory.getParkingSpot(ticket.getVehicle().getVehileType());
        parkingSlotManager.freeUpSlot(ticket.getSlotID());
        
        CostComputation computation = computationFactory.getCostComputationInstance(ticket.getVehicle().getVehileType());
        int priceToBePaid = computation.computeParkingCost(ticket);

        System.out.println("Please Pay Rs. " + priceToBePaid);
        openGate();
    }

    public void openGate() {
        System.out.println("Gate Opened");
    }
}
