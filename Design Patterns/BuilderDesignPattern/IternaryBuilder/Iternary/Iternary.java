package BuilderDesignPattern.IternaryBuilder.Iternary;

import java.util.List;

import BuilderDesignPattern.IternaryBuilder.Events.Event;
import BuilderDesignPattern.IternaryBuilder.PlacesToVisit.TouristPlace;

public class Iternary {
    private String iternaryName;
    private List<TouristPlace> placesToVisits;
    private List<Event> events;

    public Iternary(IternaryBuilder iternaryBuilder) {
        this.iternaryName = iternaryBuilder.iternaryName;
        this.placesToVisits = iternaryBuilder.placesToVisits;
        this.events = iternaryBuilder.events;
    }

    @Override
    public String toString() {
        StringBuilder tripDescription = new StringBuilder();

        if(iternaryName != null) {
            tripDescription.append(iternaryName).append("\n");
        }

        tripDescription.append("\nPlaces you have selected:\n");
        for(int i = 0; i <  placesToVisits.size(); i++) {
            tripDescription.append(placesToVisits.get(i).getDescription());
            if(i < placesToVisits.size() - 1) {
                tripDescription.append(",");
            }
        }

        tripDescription.append("\n\nEvents you have selected:\n");
        for(int i = 0; i < events.size(); i++) {
            tripDescription.append(events.get(i).getDescription());
            if(i < events.size() - 1) {
                tripDescription.append(",");
            }
        }

        return tripDescription.toString();
    }
}
