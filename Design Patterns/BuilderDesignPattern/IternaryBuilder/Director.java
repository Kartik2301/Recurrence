package BuilderDesignPattern.IternaryBuilder;

import BuilderDesignPattern.IternaryBuilder.Events.MusicEvent;
import BuilderDesignPattern.IternaryBuilder.Events.VolcanoEvent;
import BuilderDesignPattern.IternaryBuilder.Iternary.Iternary;
import BuilderDesignPattern.IternaryBuilder.Iternary.IternaryBuilder;
import BuilderDesignPattern.IternaryBuilder.PlacesToVisit.IndiaGate;
import BuilderDesignPattern.IternaryBuilder.PlacesToVisit.Monument;

public class Director {
    public static void main(String[] args) {
        IternaryBuilder iternaryBuilder = new IternaryBuilder();
        Iternary iternary = iternaryBuilder.setTripName("New Year 2025 Trip")
                                           .addEvent(new MusicEvent())
                                           .addTouristPlace(new IndiaGate())
                                           .addEvent(new VolcanoEvent())
                                           .addTouristPlace(new Monument())
                                           .buildTrip();
        
        System.out.println(iternary);
    }
}
