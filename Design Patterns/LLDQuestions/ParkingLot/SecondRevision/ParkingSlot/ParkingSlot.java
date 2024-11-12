package LLDQuestions.ParkingLot.SecondRevision.ParkingSlot;

import LLDQuestions.ParkingLot.SecondRevision.Vehicles.Vehicle;

public class ParkingSlot {
    private int parkingSlotId;
    private boolean isOccupied;
    private Vehicle vehicle;
    private int cost;
    private ParkingSlotTypes parkingSlotType;

    public ParkingSlot(int parkingSlotId, int cost, ParkingSlotTypes parkingSlotType) {
        this.parkingSlotId = parkingSlotId;
        this.cost = cost;
        this.parkingSlotType = parkingSlotType;
        this.isOccupied = false;
        this.vehicle = null;
    }

    public int getParkingSlotId() {
        return parkingSlotId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ParkingSlotTypes getParkingSlotType() {
        return parkingSlotType;
    }
    
}
