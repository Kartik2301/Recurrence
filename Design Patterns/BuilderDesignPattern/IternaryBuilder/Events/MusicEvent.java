package BuilderDesignPattern.IternaryBuilder.Events;

public class MusicEvent implements Event {
    
    @Override
    public String getDescription() {
        return "Music Event";
    }
}
