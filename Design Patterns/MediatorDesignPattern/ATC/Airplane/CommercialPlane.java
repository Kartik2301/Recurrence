package MediatorDesignPattern.ATC.Airplane;

import MediatorDesignPattern.ATC.ATCMediator;

public class CommercialPlane extends Airplane {
    public CommercialPlane(int airplaneID, ATCMediator atcMediator) {
        super(airplaneID, atcMediator);
    }

    @Override
    public void fly() {
        System.out.println("Commercial plane says fly");
    }

    @Override
    public int getFuelCapacity() {
        return 40;
    }

    public void performManouver() {
        atcMediator.onManouverPerformed(this, "Turning left by 10 degree, while increasing elevation by 5 metres");
    }
    
}
