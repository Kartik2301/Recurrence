package LLDQuestions.ParkingLot.FirstRevision.EntranceGate;

import LLDQuestions.ParkingLot.FirstRevision.Slots.ParkingSlot;
import LLDQuestions.ParkingLot.FirstRevision.Slots.ParkingSlotManagers.ParkingSlotManager;
import LLDQuestions.ParkingLot.FirstRevision.Slots.ParkingSlotManagers.ParkingSlotManagerFactory;
import LLDQuestions.ParkingLot.FirstRevision.Ticket.Ticket;
import LLDQuestions.ParkingLot.FirstRevision.Vehicle.Vehicle;

public class EntranceGate {
    ParkingSlotManagerFactory parkingSlotManagerFactory;
    ParkingSlotManager parkingSlotManager;
    Ticket ticket;

    public EntranceGate(ParkingSlotManagerFactory parkingSlotManagerFactory) {
        this.parkingSlotManagerFactory = parkingSlotManagerFactory;
        ticket = new Ticket();
    }

    public Ticket findSlotAndPark(Vehicle vehicle) {
        parkingSlotManager = parkingSlotManagerFactory.createParkingSlot(vehicle);
        ParkingSlot foundParkingSlot = parkingSlotManager.findParkingSlotAndPark(vehicle);

        if(foundParkingSlot == null) {
            return null;
        }

        return ticket.generateTicket(foundParkingSlot, vehicle);
    }
}
