package LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.ReservationDetails;

import java.util.Calendar;

import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.User.User;
import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Vehicle.Vehicle;

public class ReservationDetails {
    private int reservationID;
    private User reservedBy;
    private long reservedFrom;
    private long reservedTill;
    private Vehicle vehicle;
    private ReservationDetailsStatus reservationDetailsStatus;

    public ReservationDetails() {
       
    }

    public void createReservation(Vehicle vehicle, User user) {
        this.reservationID = 100;
        this.vehicle = vehicle;
        this.reservedBy = user;
        this.reservedFrom = Calendar.getInstance().getTimeInMillis();
        this.reservationDetailsStatus = ReservationDetailsStatus.SCHEDULED;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }

    public User getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(User reservedBy) {
        this.reservedBy = reservedBy;
    }

    public long getReservedFrom() {
        return reservedFrom;
    }

    public void setReservedFrom(long reservedFrom) {
        this.reservedFrom = reservedFrom;
    }

    public long getReservedTill() {
        return reservedTill;
    }

    public void setReservedTill(long reservedTill) {
        this.reservedTill = reservedTill;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ReservationDetailsStatus getReservationDetailsStatus() {
        return reservationDetailsStatus;
    }

    public void setReservationDetailsStatus(ReservationDetailsStatus reservationDetailsStatus) {
        this.reservationDetailsStatus = reservationDetailsStatus;
    }
}
