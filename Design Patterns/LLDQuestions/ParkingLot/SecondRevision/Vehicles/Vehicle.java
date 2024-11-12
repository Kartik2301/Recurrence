package LLDQuestions.ParkingLot.SecondRevision.Vehicles;

public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehileType;

    public Vehicle(String vehicleNumber, VehicleType vehileType) {
        this.vehicleNumber = vehicleNumber;
        this.vehileType = vehileType;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public VehicleType getVehileType() {
        return vehileType;
    }
    public void setVehileType(VehicleType vehileType) {
        this.vehileType = vehileType;
    }

}
