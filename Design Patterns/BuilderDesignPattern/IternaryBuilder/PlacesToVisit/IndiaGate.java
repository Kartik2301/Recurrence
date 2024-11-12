package BuilderDesignPattern.IternaryBuilder.PlacesToVisit;

public class IndiaGate implements TouristPlace {
    public String getDescription() {
        return "IndiaGate";
    }

    @Override
    public int getCost() {
        return 120;
    }
}
