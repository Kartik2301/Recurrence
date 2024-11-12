package LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Store;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle.ReservationStatus;
import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle.Vehicle;

public class Inventory {
    private List<Vehicle> vehicles;

    public Inventory() {
        vehicles = new ArrayList<>();
    }

    public void initializeInventory(List<Vehicle> vehicles) {
        for(Vehicle vehicle: vehicles) {
            this.vehicles.add(vehicle);
        }
    }

    public Vehicle markVehicleTaken(int vehicleNumber) {
        Vehicle vehicle = null;
        for(Vehicle v: vehicles) {
            if(v.getVehicleNumber() == vehicleNumber) {
                vehicle = v;
                break;
            }
        }

        if(vehicle == null) {
            return null;
        }
        vehicle.setReservationStatus(ReservationStatus.RESERVED);
        vehicles.remove(vehicle);

        return vehicle;
    }

    public void markVehicleAvailable(Vehicle vehicle) {
        vehicle.setReservationStatus(ReservationStatus.AVAILABLE);
        vehicles.add(vehicle);
    } 

    public void status() {
        System.out.println("Available Vehicles");
        for(Vehicle vehicle: vehicles) {
            System.out.println(vehicle.getVehicleName() + " / " + vehicle.getVehicleNumber());
        }
    }
}
