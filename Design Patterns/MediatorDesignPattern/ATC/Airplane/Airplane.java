package MediatorDesignPattern.ATC.Airplane;

import MediatorDesignPattern.ATC.ATCMediator;

public abstract class Airplane {
    protected int airplaneID;
    protected ATCMediator atcMediator;

    public Airplane(int airplaneID, ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
        this.airplaneID = airplaneID;

        atcMediator.addAirplane(this);
    }

    public abstract void fly();
    public abstract int getFuelCapacity();


    public ATCMediator getAtcMediator() {
        return atcMediator;
    }

    public void setAtcMediator(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void processUpdate(String description) {
        System.out.println("Update received by plane with ID = " + airplaneID + ", - " + description);
    }

    public abstract void performManouver();
}
