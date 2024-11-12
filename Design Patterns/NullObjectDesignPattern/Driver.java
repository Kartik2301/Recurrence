package NullObjectDesignPattern;

public class Driver {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle = vehicleFactory.getVehicleObject(VehicleType.SHIP);
        
        System.out.println("Seating Capcity is: " + vehicle.getSeatingCapacity());
        System.out.println("Tank Capacity is: " + vehicle.getTankCapacity());
    }
}
