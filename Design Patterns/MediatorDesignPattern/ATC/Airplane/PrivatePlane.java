package MediatorDesignPattern.ATC.Airplane;

import MediatorDesignPattern.ATC.ATCMediator;

public class PrivatePlane extends Airplane {
    public PrivatePlane(int airplaneID, ATCMediator atcMediator) {
        super(airplaneID, atcMediator);
    }

    @Override
    public void fly() {
        System.out.println("Private Plane says fly");
    }

    @Override
    public int getFuelCapacity() {
        return 20;
    }

    public void performManouver() {
        atcMediator.onManouverPerformed(this, "Turning right by 40 degree, while increasing elevation by 20 metres");
    }
    
}
