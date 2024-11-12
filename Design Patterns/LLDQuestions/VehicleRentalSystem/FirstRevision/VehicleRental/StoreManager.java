package LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.BookingManager.User;
import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Store.Location;
import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Store.Store;
import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle.Car;
import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle.ReservationStatus;
import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle.Vehicle;
import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle.VehicleType;

public class StoreManager {
    private static Store store;
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            Vehicle car = new Car(i * 4, "Ferrari x:" + i, 500 + i * 60, ReservationStatus.AVAILABLE, (i + 3) * 600, VehicleType.CAR);
            vehicles.add(car);
        }

        for(int i = 0; i < 5; i++) {
            Vehicle bike = new Car((i + 2) * 5, "Kawasaki x:" + i, 300 + i * 22, ReservationStatus.AVAILABLE, (i + 1) * 234, VehicleType.BIKE);
            vehicles.add(bike);
        }
        
        store = new Store(1, new Location("Bangalore"), vehicles);

        store.getInventoryStatus();

        for(int i = 0; i < 8; i++) {
            // User comes in
            User user = new User("Jaxon");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Timestamp(System.currentTimeMillis()));
            calendar.add(Calendar.DAY_OF_WEEK, 3);

            store.bookVehicle(vehicles.get(i).getVehicleNumber(), user, 
                              new Timestamp(System.currentTimeMillis()), 
                              new Timestamp(calendar.getTime().getTime()));

            store.getInventoryStatus();
        }

    }
}
