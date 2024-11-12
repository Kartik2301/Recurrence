package LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.BookingManager;

import java.sql.Timestamp;

import LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle.Vehicle;

public class Booking {
    private static int CURRENT_ID = 0;
    private int bookingID;
    private Vehicle vehicle;
    private User user;
    private Timestamp bookingFrom;
    private Timestamp bookingTo;
    private BookingStatus status;

    public Booking() {
        this.bookingID = CURRENT_ID++;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Timestamp getBookingFrom() {
        return bookingFrom;
    }
    public void setBookingFrom(Timestamp bookingFrom) {
        this.bookingFrom = bookingFrom;
    }
    public Timestamp getBookingTo() {
        return bookingTo;
    }
    public void setBookingTo(Timestamp bookingTo) {
        this.bookingTo = bookingTo;
    }
    public BookingStatus getStatus() {
        return status;
    }
    public void setStatus(BookingStatus status) {
        this.status = status;
    }
    public int getBookingID() {
        return bookingID;
    }
}
