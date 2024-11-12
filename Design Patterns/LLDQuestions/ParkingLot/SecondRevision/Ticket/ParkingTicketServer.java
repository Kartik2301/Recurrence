package LLDQuestions.ParkingLot.SecondRevision.Ticket;

import LLDQuestions.ParkingLot.SecondRevision.Vehicles.Vehicle;

public class ParkingTicketServer {
    public ParkingTicket createTicket(int slotID, Vehicle vehicle) {
        return new ParkingTicket(slotID, vehicle);
    }
}
