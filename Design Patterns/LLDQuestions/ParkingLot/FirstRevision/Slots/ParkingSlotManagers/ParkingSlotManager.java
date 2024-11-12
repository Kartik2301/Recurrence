package LLDQuestions.ParkingLot.FirstRevision.Slots.ParkingSlotManagers;

import java.util.Stack;

import LLDQuestions.ParkingLot.FirstRevision.Slots.ParkingSlot;
import LLDQuestions.ParkingLot.FirstRevision.Vehicle.Vehicle;

public abstract class ParkingSlotManager {
    Stack<ParkingSlot> parkingSlots;

    public ParkingSlotManager(Stack<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot findParkingSlot() {
        if(parkingSlots.isEmpty()) {
            return null;
        }
        return parkingSlots.pop();
    }

    public void parkVehicle(ParkingSlot parkingSlot, Vehicle vehicle) {
        parkingSlot.setEmpty(false);
        parkingSlot.setVehicle(vehicle);
    }

    public void removeVehicle(ParkingSlot parkingSlot) {
        parkingSlot.setEmpty(true);
        parkingSlot.setVehicle(null);

        parkingSlots.add(parkingSlot);
    }

    public ParkingSlot findParkingSlotAndPark(Vehicle vehicle) {        
        ParkingSlot foundParkingSlot = findParkingSlot();
        if(foundParkingSlot == null) {
            return null;
        }

        parkVehicle(foundParkingSlot, vehicle);
        return foundParkingSlot;
    }

    public void addSlots(ParkingSlot addParkingSlot) {
        parkingSlots.add(addParkingSlot);
    }

    public void removeSlots(ParkingSlot addParkingSlot) {

    }
}
