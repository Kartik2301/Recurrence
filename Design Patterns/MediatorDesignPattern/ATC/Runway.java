package MediatorDesignPattern.ATC;

import java.util.ArrayList;

import MediatorDesignPattern.ATC.Airplane.Airplane;
import MediatorDesignPattern.ATC.Airplane.CommercialPlane;
import MediatorDesignPattern.ATC.Airplane.PrivatePlane;

public class Runway {
    public static void main(String[] args) {
        ATCMediator atcMediator = new ATCMediator(new ArrayList<>());

        Airplane commercialPlane1 = new CommercialPlane(1, atcMediator);
        Airplane commercialPlane2 = new CommercialPlane(2, atcMediator);
        Airplane commercialPlane3 = new CommercialPlane(3, atcMediator);

        Airplane privatePlane1 = new PrivatePlane(4, atcMediator);
        Airplane privatePlane2 = new PrivatePlane(5, atcMediator);

        commercialPlane1.performManouver();

        privatePlane2.performManouver();
    }
}
