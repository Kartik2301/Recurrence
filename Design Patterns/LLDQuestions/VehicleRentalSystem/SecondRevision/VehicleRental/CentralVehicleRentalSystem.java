package LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental;

import java.util.List;

import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Invoice.Invoice;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Location.Location;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.ReservationDetails.ReservationDetails;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Store.Store;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.User.User;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Vehicle.VechicleTypes;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Vehicle.Vehicle;

public class CentralVehicleRentalSystem {
    List<Store> stores;
    List<User> users;

    public CentralVehicleRentalSystem(List<Store> stores, List<User> users) {
        this.stores = stores;
        this.users = users;
    }

    public void serviceRequests() {
        // This is where the user comes and specifies the location of the store he's interested in
        User user = users.get(0);
        Store store = getStore(new Location("Berlin", "Lenin Grad", "Germany", 9765));
        List<Vehicle> vehicles = store.getAllVehicles(VechicleTypes.BIKE);

        ReservationDetails reservationDetails = reserveVehicle(store, vehicles.get(0), user);

        // Invoice Generation
        Invoice invoice = new Invoice(reservationDetails);
        System.out.println("Your bill is Rs. " + invoice.getAmount());

        // Reservation has been made, Reservation Status is SCHEDULED

        // Change the reservation status to INPROGRESS
        store.completeReservation(reservationDetails);
    }

    public Store getStore(Location location) {
        // Search in stores and return the one having the specified location
        return stores.get(0);
    }

    public ReservationDetails reserveVehicle(Store store, Vehicle vehicle, User user) {
        return store.reserveVehicle(vehicle, user);
    }
}
