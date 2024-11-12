package LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Store;

import java.sql.Timestamp;
import java.util.List;

import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.BookingManager.BookingManager;
import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.BookingManager.User;
import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle.Vehicle;

public class Store {
    private Inventory inventory;
    private int storeId;
    private BookingManager bookingManager;
    private Location location;

    public Store(int storeId, Location location, List<Vehicle> vehicles) {
        this.bookingManager = new BookingManager();
        this.storeId = storeId;
        this.location = location;
        this.inventory = new Inventory();
        this.inventory.initializeInventory(vehicles);
    }

    public int bookVehicle(int vehicleNumber, User user, Timestamp from, Timestamp to) {
        Vehicle vehicle = this.inventory.markVehicleTaken(vehicleNumber);
        if(vehicle == null) {
            System.out.println("Booking Failed");
            return -1;
        }
        return this.bookingManager.createBooking(vehicle, user, from, to);
    }

    public void removeBooking(int bookingID) {
        Vehicle vehicle = this.bookingManager.removeBooking(bookingID);
        this.inventory.markVehicleAvailable(vehicle);
    }

    public int getStoreId() {
        return storeId;
    }

    public Location getLocation() {
        return location;
    }

    public void getInventoryStatus() {
        this.inventory.status();
    }
}
