package LLDQuestions.ParkingLot.SecondRevision.Gates;

import LLDQuestions.ParkingLot.SecondRevision.ParkingSlotManager.ParkingSlotManager;
import LLDQuestions.ParkingLot.SecondRevision.ParkingSlotManager.ParkingSlotManagerFactory;
import LLDQuestions.ParkingLot.SecondRevision.Ticket.ParkingTicket;
import LLDQuestions.ParkingLot.SecondRevision.Ticket.ParkingTicketServer;
import LLDQuestions.ParkingLot.SecondRevision.Vehicles.Vehicle;
import LLDQuestions.ParkingLot.SecondRevision.Vehicles.VehicleType;

public class EntranceGate {
    private ParkingSlotManager parkingSlotManager;
    private ParkingSlotManagerFactory parkingSlotManagerFactory;
    private ParkingTicketServer ticketServer;

    public EntranceGate(ParkingSlotManagerFactory parkingSlotManagerFactory, ParkingTicketServer ticketServer) {
        this.parkingSlotManagerFactory = parkingSlotManagerFactory;
        this.ticketServer = ticketServer;
    }

    public ParkingTicket findVehicleParkingSlotAndFetchTicket(Vehicle vehicle) {
        // Scanner scans the vehicle details
        VehicleType vehicleType = vehicle.getVehileType();

        parkingSlotManager = parkingSlotManagerFactory.getParkingSpot(vehicleType);

        int slotID;
        if((slotID = parkingSlotManager.findSpotAndParkVehicle(vehicle)) == -1) {
            System.out.println("Parking Lot is full, please try later.");
            return null;
        }
        
        // Generate Ticket
        return ticketServer.createTicket(slotID, vehicle);
    }

    public void getParkingStats() {
        parkingSlotManager.getParkingStats();
    }
}
