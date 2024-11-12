package LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle;

public class Car extends Vehicle {

    public Car(int vehicleID, String vehicleName, int vehicleNumber, ReservationStatus reservationStatus,
            int hourlyRentalCost, VehicleType vehicleType) {
        super(vehicleID, vehicleName, vehicleNumber, reservationStatus, hourlyRentalCost, vehicleType);
    }
    
}
