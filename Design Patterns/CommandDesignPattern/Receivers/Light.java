package CommandDesignPattern.Receivers;

public class Light implements Receiver {

    @Override
    public void turnOn() {
        System.out.println("Light Has Been Turned On");
    }

    @Override
    public void turnOff() {
        System.out.println("Light Has Been Turned Off");
    }

    public void setIllumination() {
        System.out.println("Illumination is set to the requested level");
    }
    
}
