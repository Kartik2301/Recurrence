package LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Invoice;

import java.util.Calendar;

import LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.ReservationDetails.ReservationDetails;

public class Invoice {
    private ReservationDetails reservationDetails;
    private int amount;
    private boolean isBillPaid;

    public Invoice(ReservationDetails reservationDetails) {
        this.reservationDetails = reservationDetails;
        this.amount = computeCost();
        this.isBillPaid = false;
    }

    public int computeCost() {
        long differenceInMillis = Calendar.getInstance().getTimeInMillis() - reservationDetails.getReservedFrom();
        int differenceInHours = (int) (differenceInMillis / (1000 * 3600));
        return (differenceInHours + 1) * reservationDetails.getVehicle().getHourlyRentalCost();
    }

    public ReservationDetails getReservationDetails() {
        return reservationDetails;
    }

    public void setReservationDetails(ReservationDetails reservationDetails) {
        this.reservationDetails = reservationDetails;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isBillPaid() {
        return isBillPaid;
    }

    public void setBillPaid(boolean isBillPaid) {
        this.isBillPaid = isBillPaid;
    }
}
