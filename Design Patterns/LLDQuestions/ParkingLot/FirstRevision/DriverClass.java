package LLDQuestions.ParkingLot.FirstRevision;

import LLDQuestions.ParkingLot.FirstRevision.EntranceGate.EntranceGate;
import LLDQuestions.ParkingLot.FirstRevision.ExitGate.ExitGate;
import LLDQuestions.ParkingLot.FirstRevision.ExitGate.CostComputation.CostComputationFactory;
import LLDQuestions.ParkingLot.FirstRevision.Slots.ParkingSlotManagers.ParkingSlotManagerFactory;
import LLDQuestions.ParkingLot.FirstRevision.Ticket.Ticket;
import LLDQuestions.ParkingLot.FirstRevision.Vehicle.Vehicle;
import LLDQuestions.ParkingLot.FirstRevision.Vehicle.Vehicle.VT;

public class DriverClass {
    public static void main (String [] args) {
        ParkingSlotManagerFactory parkingSlotManagerFactory = new ParkingSlotManagerFactory();
        CostComputationFactory costComputationFactory = new CostComputationFactory();
        EntranceGate entranceGate = new EntranceGate(parkingSlotManagerFactory);
        ExitGate exitGate = new ExitGate(parkingSlotManagerFactory, costComputationFactory);

        // Flood of Vehicle incoming
        for(int i = 0; i < 10; i++) {
            Vehicle vehicle;
            if(i % 2 == 0) {
                vehicle = new Vehicle(i*5 + 7, VT.TwoWheeler);
            } else {
                vehicle = new Vehicle(i*9 + 4, VT.FourWheeler);
            }
            
            Ticket ticket = entranceGate.findSlotAndPark(vehicle);
    
            if(ticket != null) {

                System.out.println("---------------------------------------------------");
                System.out.println("Your Vehicle " + ticket.getVehicle().getVehicleNumber() + " has been parked at slot: " + ticket.getParkingSlot().getId());
                System.out.println("Ticket created at: " + ticket.getCreatedAt());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Now leave
                int parkingCharges = exitGate.releaseParkingSlot(ticket);
                System.out.println("Your bill is Rs. " + parkingCharges * 1000);
    
            } else {
                System.out.println("Sorry we are full, now get!!");
            }
        }
    }
}
