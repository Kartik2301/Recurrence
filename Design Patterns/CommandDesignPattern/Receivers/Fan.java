package CommandDesignPattern.Receivers;

public class Fan implements Receiver {
    @Override
    public void turnOn() {
        System.out.println("Fan Has Been Turned On");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan Has Been Turned Off");
    }
}
