package LLDQuestions.ParkingLot.SecondRevision.ParkingStrategies;

import java.util.List;

import LLDQuestions.ParkingLot.SecondRevision.ParkingSlot.ParkingSlot;
import LLDQuestions.ParkingLot.SecondRevision.Vehicles.VehicleType;

public class NearestToEntranceGate implements ParkingStrategy {
        @Override
    public int findParkingSpot(List<ParkingSlot> availableSlots, VehicleType vehicleType) {
        return availableSlots.getLast().getParkingSlotId();
    }
}
