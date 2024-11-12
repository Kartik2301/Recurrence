package LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Store;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Location.Location;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.ReservationDetails.ReservationDetails;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.ReservationDetails.ReservationDetailsStatus;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.User.User;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Vehicle.VechicleTypes;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Vehicle.Vehicle;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Vehicle.VehicleInventory;

public class Store {
    private String storeAddress;
    private int storeID;
    private Location location;
    private VehicleInventory vehicleInventory;
    private List<ReservationDetails> reservationDetails;

    public Store(String storeAddress, int storeID, Location location) {
        this.storeAddress = storeAddress;
        this.storeID = storeID;
        this.location = location;

        reservationDetails = new ArrayList<>();
    }

    public List<Vehicle> getAllVehicles(VechicleTypes vechicleType) {
        return vehicleInventory.getAllVehicles(vechicleType);
    }

    public void setupInventory(List<Vehicle> vehicles) {
        vehicleInventory = new VehicleInventory(vehicles);
    }

    public ReservationDetails reserveVehicle(Vehicle vehicle, User user) {
        ReservationDetails reservationDetail = new ReservationDetails();
        reservationDetail.createReservation(vehicle, user);

        reservationDetails.add(reservationDetail);
        return reservationDetail;
    }

    public void completeReservation(ReservationDetails reservationDetails) {
        reservationDetails.setReservationDetailsStatus(ReservationDetailsStatus.INPROGRESS);
    }

    // Getters and Setters

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    
}
