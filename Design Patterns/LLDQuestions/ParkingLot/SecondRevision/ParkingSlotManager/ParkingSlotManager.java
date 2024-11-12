package LLDQuestions.ParkingLot.SecondRevision.ParkingSlotManager;

import java.util.List;

import LLDQuestions.ParkingLot.SecondRevision.ParkingSlot.ParkingSlot;
import LLDQuestions.ParkingLot.SecondRevision.ParkingStrategies.ParkingStrategy;
import LLDQuestions.ParkingLot.SecondRevision.Vehicles.Vehicle;
import LLDQuestions.ParkingLot.SecondRevision.Vehicles.VehicleType;

public abstract class ParkingSlotManager {
    protected List<ParkingSlot> parkingSlots;
    protected ParkingStrategy parkingStrategy;

    ParkingSlotManager(List<ParkingSlot> parkingSlots, ParkingStrategy parkingStrategy) {
        this.parkingSlots = parkingSlots;
        this.parkingStrategy = parkingStrategy;
    }

    // Template Method Design Pattern
    public final int findSpotAndParkVehicle(Vehicle vehicle) {
        // Abstract
        int slot = findParkingSlot(vehicle.getVehileType());

        if(slot != -1) {
            // Concrete
            parkVehicleAt(slot, vehicle);
        }
        
        return slot;
    }

    public void freeUpSlot(int slotID) {
        ParkingSlot parkingSlot = findSlotById(slotID);

        parkingSlot.setOccupied(false);
        parkingSlot.setVehicle(null);
        parkingSlots.add(parkingSlot);
    }

    protected ParkingSlot findSlotById(int slotID) {
        ParkingSlot parkingSlot = null;
        for(ParkingSlot slot: parkingSlots) {
            if(slot.getParkingSlotId() == slotID) {
                parkingSlot = slot;
                break;
            }
        }
        return parkingSlot;
    }

    protected boolean parkVehicleAt(int slotID, Vehicle vehicle) {
        ParkingSlot parkingSlot = findSlotById(slotID);
        if(parkingSlot == null) {
            return false;
        }

        parkingSlot.setOccupied(true);
        parkingSlot.setVehicle(vehicle);
        return true;
    }

    protected abstract int findParkingSlot(VehicleType vehicleType);

    public void getParkingStats() {
        for(ParkingSlot slot: parkingSlots) {
            System.out.println(slot.getParkingSlotId() + " - " + slot.getParkingSlotType().name() + " Available: " + slot.isOccupied());
        }
    }
}
