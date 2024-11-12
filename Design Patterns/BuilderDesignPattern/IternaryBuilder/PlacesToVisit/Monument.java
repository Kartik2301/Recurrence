package BuilderDesignPattern.IternaryBuilder.PlacesToVisit;

public class Monument implements TouristPlace {
    public String getDescription() {
        return "Monument";
    }

    @Override
    public int getCost() {
        return 1000;
    }
}
