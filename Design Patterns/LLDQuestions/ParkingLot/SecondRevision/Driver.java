package LLDQuestions.ParkingLot.SecondRevision;

import LLDQuestions.ParkingLot.SecondRevision.Gates.EntranceGate;
import LLDQuestions.ParkingLot.SecondRevision.Gates.ExitGate;
import LLDQuestions.ParkingLot.SecondRevision.Gates.CostComputation.CostComputation.CostComputationFactory;
import LLDQuestions.ParkingLot.SecondRevision.ParkingSlotManager.ParkingSlotManagerFactory;
import LLDQuestions.ParkingLot.SecondRevision.Ticket.ParkingTicket;
import LLDQuestions.ParkingLot.SecondRevision.Ticket.ParkingTicketServer;
import LLDQuestions.ParkingLot.SecondRevision.Vehicles.Vehicle;
import LLDQuestions.ParkingLot.SecondRevision.Vehicles.VehicleType;

public class Driver {
    public static void main(String[] args) {
        ParkingTicketServer ticketServer = new ParkingTicketServer();
        ParkingSlotManagerFactory parkingSlotManagerFactory = new ParkingSlotManagerFactory();
        CostComputationFactory costComputationFactory = new CostComputationFactory();

        EntranceGate entranceGate = new EntranceGate(parkingSlotManagerFactory, ticketServer);
        ExitGate exitGate = new ExitGate(parkingSlotManagerFactory, costComputationFactory);
        Vehicle car = new Vehicle("SH 23 RT 3452", VehicleType.CAR);
        
        entranceGate.findVehicleParkingSlotAndFetchTicket(car);
        entranceGate.getParkingStats();

        ParkingTicket ticket = entranceGate.findVehicleParkingSlotAndFetchTicket(car);

        assert(ticket != null);

        System.out.println(ticket);

        // Time to Leave
        exitGate.freeUpParkingSlot(ticket);
        entranceGate.getParkingStats();
    }
}
