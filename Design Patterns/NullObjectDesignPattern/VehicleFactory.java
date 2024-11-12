package NullObjectDesignPattern;

public class VehicleFactory {
    public Vehicle getVehicleObject(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return new Car();
            case BIKE:
                return new Bike();
            default:
                return new NullObject();
        }
    }
}
