package LLDQuestions.ParkingLot.SecondRevision.ParkingSlotManager;

import java.util.List;

import LLDQuestions.ParkingLot.SecondRevision.ParkingSlot.ParkingSlot;
import LLDQuestions.ParkingLot.SecondRevision.ParkingStrategies.ParkingStrategy;
import LLDQuestions.ParkingLot.SecondRevision.Vehicles.VehicleType;

public class FourWheelerSlotManager extends ParkingSlotManager {
    public FourWheelerSlotManager(List<ParkingSlot> parkingSlots, ParkingStrategy parkingStrategy) {
        super(parkingSlots, parkingStrategy);
    }

    @Override
    public int findParkingSlot(VehicleType vehicleType) {
        return parkingStrategy.findParkingSpot(parkingSlots, vehicleType);
    }
}
