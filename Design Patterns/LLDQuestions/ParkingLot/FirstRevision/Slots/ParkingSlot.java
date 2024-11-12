package LLDQuestions.ParkingLot.FirstRevision.Slots;

import LLDQuestions.ParkingLot.FirstRevision.Vehicle.Vehicle;

public abstract class ParkingSlot {
    private int id;
    private Vehicle vehicle;
    private boolean isEmpty;
    private int slotPrice;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public int getSlotPrice() {
        return slotPrice;
    }

    public void setSlotPrice(int slotPrice) {
        this.slotPrice = slotPrice;
    }
}
