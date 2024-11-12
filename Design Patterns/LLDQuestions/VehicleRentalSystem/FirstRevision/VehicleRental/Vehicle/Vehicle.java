package LLDQuestions.VehicleRentalSystem.FirstRevision.VehicleRental.Vehicle;

public abstract class Vehicle {
    private int vehicleID;
    private String vehicleName;
    private int vehicleNumber;
    private ReservationStatus reservationStatus;
    private int hourlyRentalCost;
    private VehicleType vehicleType;

    public Vehicle(int vehicleID, String vehicleName, int vehicleNumber, ReservationStatus reservationStatus,
            int hourlyRentalCost, VehicleType vehicleType) {
        this.vehicleID = vehicleID;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.reservationStatus = reservationStatus;
        this.hourlyRentalCost = hourlyRentalCost;
        this.vehicleType = vehicleType;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public int getHourlyRentalCost() {
        return hourlyRentalCost;
    }

    public void setHourlyRentalCost(int hourlyRentalCost) {
        this.hourlyRentalCost = hourlyRentalCost;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
