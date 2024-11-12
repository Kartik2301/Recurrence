package LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Vehicle;

public class Vehicle {
    private int id;
    private int vehicleNumber;
    private VechicleTypes vechicleType;
    private String modelName;
    private ReservationStatus reservationStatus;
    private int hourlyRentalCost;

    public Vehicle(int id, int vehicleNumber, VechicleTypes vechicleType, String modelName, int hourlyRentalCost) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.vechicleType = vechicleType;
        this.modelName = modelName;
        this.reservationStatus = ReservationStatus.AVAILABLE;
        this.hourlyRentalCost = hourlyRentalCost;
    }

    public int getId() {
        return id;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public VechicleTypes getVechicleType() {
        return vechicleType;
    }

    public String getModelName() {
        return modelName;
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
}
