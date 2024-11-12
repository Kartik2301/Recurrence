package LLDQuestions.Cricbuzz.Match;

public class OneDayMatchType implements MatchType {

    @Override
    public int getNumberOfOversInTheMatch() {
        return 50;
    }

    @Override
    public int getMaxNumberOfOversAllowedByBowler() {
        return 10;
    }
    
}
