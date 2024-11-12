package CommandDesignPattern.Receivers;

public class Microwave implements Receiver {

    @Override
    public void turnOn() {
        System.out.println("Microwave Has Been Turned On");
    }

    @Override
    public void turnOff() {
        System.out.println("Microwave Has Been Turned Off");
    }
    
}
