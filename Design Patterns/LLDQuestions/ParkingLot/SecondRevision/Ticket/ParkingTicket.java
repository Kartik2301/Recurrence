package LLDQuestions.ParkingLot.SecondRevision.Ticket;

import java.sql.Timestamp;

import LLDQuestions.ParkingLot.SecondRevision.Vehicles.Vehicle;

public class ParkingTicket {
    private int slotID;
    private Vehicle vehicle;
    private Timestamp createdAt;

    public ParkingTicket(int slotID, Vehicle vehicle) {
        this.slotID = slotID;
        this.vehicle = vehicle;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public int getSlotID() {
        return slotID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Vehicle Number: " + vehicle.getVehicleNumber() + "\n" +
               "Parking Spot: " + slotID + "\n" +
               "Time of Entering: " + createdAt;
    }
}
