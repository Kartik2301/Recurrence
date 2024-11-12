package LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Location.Location;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Store.Store;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.User.User;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Vehicle.VechicleTypes;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Vehicle.Vehicle;

public class DriverClass {

    private static List<Vehicle> addVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(1, 102, VechicleTypes.BIKE, "the most beautiful bike, wow!!", 250));
        vehicles.add(new Vehicle(2, 489, VechicleTypes.CAR, "the most beautiful car, wow!!", 500));
        vehicles.add(new Vehicle(3, 680, VechicleTypes.BIKE, "the fastest bike, wow!!", 1500));
        vehicles.add(new Vehicle(4, 400, VechicleTypes.CAR, "BENZ", 10000));

        return vehicles;
    }

    private static List<User> addUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("hattoda", 9211, "420"));
        users.add(new User("kabada", 156, "3489"));
        users.add(new User("james", 45677, "3248u5"));

        return users;
    }

    private static List<Store> addStores() {
        List<Store> stores = new ArrayList<>();
        stores.add(new Store("Kabada Nagar", 1, 
                             new Location("Pyongyang", "Pyongyang Province", "North Korea", 43429)));

        stores.get(0).setupInventory(addVehicles());
    
        stores.add(new Store("Niggamma Pur", 2, 
                             new Location("Moscow", "Moscow", "Russia", 11356)));

        stores.get(1).setupInventory(addVehicles());

        return stores;
    }

    public static void main (String [] args) {
        List<User> users = addUsers();
        List<Store> stores = addStores();

        CentralVehicleRentalSystem centralVehicleRentalSystem = new CentralVehicleRentalSystem(stores, users);  
        centralVehicleRentalSystem.serviceRequests();
    }
}
