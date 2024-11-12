package BuilderDesignPattern.IternaryBuilder.Iternary;

import java.util.ArrayList;
import java.util.List;

import BuilderDesignPattern.IternaryBuilder.Events.Event;
import BuilderDesignPattern.IternaryBuilder.PlacesToVisit.TouristPlace;

public class IternaryBuilder {
    String iternaryName;
    List<TouristPlace> placesToVisits;
    List<Event> events;

    public IternaryBuilder() {
        iternaryName = new String();
        placesToVisits = new ArrayList<>();
        events = new ArrayList<>();
    }

    public IternaryBuilder addTouristPlace(TouristPlace place) {
        placesToVisits.add(place);
        return this;
    }

    public IternaryBuilder addEvent(Event event) {
        events.add(event);
        return this;
    }

    public IternaryBuilder setTripName(String iternaryName) {
        this.iternaryName = iternaryName;
        return  this;
    }

    public Iternary buildTrip() {
        return new Iternary(this);
    }
}
