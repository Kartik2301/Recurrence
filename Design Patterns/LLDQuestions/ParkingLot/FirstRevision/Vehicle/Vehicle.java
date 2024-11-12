package LLDQuestions.ParkingLot.FirstRevision.Vehicle;

public class Vehicle {
    public enum VT {
        TwoWheeler,
        FourWheeler,
        Truck;
    }

    private int vehicleNumber;
    private VT vehicleType;

    public Vehicle(int vehicleNumber, VT vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public int getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(int vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VT getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VT vehicleType) {
        this.vehicleType = vehicleType;
    }
}
