package LLDQuestions.ParkingLot.FirstRevision.Ticket;

import java.util.Calendar;

import LLDQuestions.ParkingLot.FirstRevision.Slots.ParkingSlot;
import LLDQuestions.ParkingLot.FirstRevision.Vehicle.Vehicle;

public class Ticket {

    private long createdAt;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

    public long getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Ticket generateTicket(ParkingSlot parkingSlot, Vehicle vehicle) {
        Ticket ticket = new Ticket();
        ticket.setParkingSlot(parkingSlot);
        ticket.setVehicle(vehicle);
        ticket.setCreatedAt(Calendar.getInstance().getTimeInMillis());

        return ticket;
    }

}
