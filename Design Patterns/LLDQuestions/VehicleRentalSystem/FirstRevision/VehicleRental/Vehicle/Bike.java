package LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle;

public class Bike extends Vehicle {

    public Bike(int vehicleID, String vehicleName, int vehicleNumber, ReservationStatus reservationStatus,
            int hourlyRentalCost, VehicleType vehicleType) {
        super(vehicleID, vehicleName, vehicleNumber, reservationStatus, hourlyRentalCost, vehicleType);
    }
    
}
