package LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.BookingManager;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle.Vehicle;

public class BookingManager {
    private List<Booking> bookings;

    public BookingManager() {
        bookings = new ArrayList<>();
    }

    public int createBooking(Vehicle vehicle, User user, Timestamp from, Timestamp to) {
        Booking booking = new Booking();
        booking.setVehicle(vehicle);
        booking.setUser(user);
        booking.setBookingFrom(from);
        booking.setBookingTo(to);
        booking.setStatus(BookingStatus.UPCOMING);
        bookings.add(booking);

        System.out.println("Booking Successfull!!");
        System.out.println("Details: ");
        System.out.println(vehicle.getVehicleName() + " booked by: " + user.getUserName());

        return booking.getBookingID();
    }

    public Vehicle removeBooking(int bookingID) {
        Booking booking = null;

        for(Booking vehicleBooking: bookings) {
            if(vehicleBooking.getBookingID() == bookingID) {
                booking = vehicleBooking;
                break;
            }
        }

        bookings.remove(booking);
        booking.setStatus(BookingStatus.COMPLETED);
        return booking.getVehicle();
    }

}
