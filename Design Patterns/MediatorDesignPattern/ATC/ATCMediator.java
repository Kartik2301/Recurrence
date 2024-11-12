package MediatorDesignPattern.ATC;

import java.util.List;

import MediatorDesignPattern.ATC.Airplane.Airplane;

public class ATCMediator {
    private List<Airplane> airplanes;

    public ATCMediator(List<Airplane> airplanes) {
        this.airplanes = airplanes;
    }

    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public void onManouverPerformed(Airplane targetAirplane, String description) {
        String targetPlaneDescription = "Performed by Airplane: " + targetAirplane.getClass().getSimpleName() + ", ID: " + targetAirplane.getAirplaneID();
        description = new StringBuilder(description).append(targetPlaneDescription).toString();
        for(Airplane airplane: airplanes) {
            if(airplane.getAirplaneID() != targetAirplane.getAirplaneID()) {
                airplane.processUpdate(description);
            }
        }
    }
}
