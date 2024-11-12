package LLDQuestions.ParkingLot.SecondRevision.ParkingSlotManager;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.ParkingLot.SecondRevision.ParkingSlot.FourWheelerParkingSlot;
import LLDQuestions.ParkingLot.SecondRevision.ParkingSlot.ParkingSlot;
import LLDQuestions.ParkingLot.SecondRevision.ParkingSlot.TwoWheelerParkingSlot;
import LLDQuestions.ParkingLot.SecondRevision.ParkingStrategies.NearestToEntranceGate;
import LLDQuestions.ParkingLot.SecondRevision.ParkingStrategies.NearestToExitGate;
import LLDQuestions.ParkingLot.SecondRevision.Vehicles.VehicleType;

public class ParkingSlotManagerFactory {
    private ParkingSlotManager twoWheelerParkingSlotManager;
    private ParkingSlotManager fourWheelerParkingSlotManager;

    public ParkingSlotManagerFactory() {
        // Create 20, two-wheeler parking slots
        List<ParkingSlot> twoWheelerParkingSlots = new ArrayList<>();
        int parkingSlotID = 1;
        for(int i = 0; i < 20; i++) {
            twoWheelerParkingSlots.add(new TwoWheelerParkingSlot(parkingSlotID++));
        }

        // Create 10, four-wheeler parking slots
        List<ParkingSlot> fourWheelerParkingSlots = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            fourWheelerParkingSlots.add(new FourWheelerParkingSlot(parkingSlotID++));
        }

        twoWheelerParkingSlotManager = new TwoWheelerSlotManager(twoWheelerParkingSlots, new NearestToEntranceGate());
        fourWheelerParkingSlotManager = new FourWheelerSlotManager(fourWheelerParkingSlots, new NearestToExitGate());
    }

    public ParkingSlotManager getParkingSpot(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE:
                return twoWheelerParkingSlotManager;
            case CAR:
                return fourWheelerParkingSlotManager;
            default:
                break;
        }
        return null;
    }
}
