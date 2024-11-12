package BuilderDesignPattern.IternaryBuilder.PlacesToVisit;

public class FortsTrip implements TouristPlace {

    @Override
    public String getDescription() {
        return "Forts";
    }

    @Override
    public int getCost() {
        return 300;
    }
    
}
