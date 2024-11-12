package NullObjectDesignPattern;

public class Bike implements Vehicle {

    @Override
    public int getSeatingCapacity() {
        return 2;
    }

    @Override
    public int getTankCapacity() {
        return 15;
    }
    
}
