package LLDQuestions.ParkingLot.FirstRevision.Slots.ParkingSlotManagers;

import java.util.Stack;

import LLDQuestions.ParkingLot.FirstRevision.Slots.FourWheelerSlot;
import LLDQuestions.ParkingLot.FirstRevision.Slots.ParkingSlot;
import LLDQuestions.ParkingLot.FirstRevision.Slots.TwoWheelerSlot;
import LLDQuestions.ParkingLot.FirstRevision.Vehicle.Vehicle;

public class ParkingSlotManagerFactory {
    private int fourWheelerSlotsCount = 400;
    private int twoWheelerSlotsCount = 600;

    Stack<ParkingSlot> twoWheelerParkingSlots;
    Stack<ParkingSlot> fourWheelerParkingSlots;

    private void initTwoWheelerParkingSlots(Stack<ParkingSlot> twoWheelerParkingSlots) {
        for(int i = 0; i < twoWheelerSlotsCount; i++) {
            ParkingSlot parkingSlot = new TwoWheelerSlot();

            parkingSlot.setVehicle(null);
            parkingSlot.setEmpty(true);
            parkingSlot.setId(i + 1);

            twoWheelerParkingSlots.add(parkingSlot);
        }
    }

    private void initFourWheelerParkingSlots(Stack<ParkingSlot> fourWheelerParkingSlots) {
        for(int i = 0; i < fourWheelerSlotsCount; i++) {
            ParkingSlot parkingSlot = new FourWheelerSlot();

            parkingSlot.setVehicle(null);
            parkingSlot.setEmpty(true);
            parkingSlot.setId(i + 1);
            
            fourWheelerParkingSlots.add(parkingSlot);
        }
    }

    public ParkingSlotManagerFactory() {
        twoWheelerParkingSlots = new Stack<>();
        fourWheelerParkingSlots = new Stack<>();

        initTwoWheelerParkingSlots(twoWheelerParkingSlots);
        initFourWheelerParkingSlots(fourWheelerParkingSlots);
    }

    public ParkingSlotManager createParkingSlot(Vehicle vehicle) {
        switch (vehicle.getVehicleType()) {
            case TwoWheeler:
                return new TwoWheelerSlotManager(twoWheelerParkingSlots);
            case FourWheeler:
                return new FourWheelerSlotManager(fourWheelerParkingSlots);
            default:
                return null;
        }
    }
}
