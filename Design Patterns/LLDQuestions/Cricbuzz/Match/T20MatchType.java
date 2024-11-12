package LLDQuestions.Cricbuzz.Match;

public class T20MatchType implements MatchType {

    @Override
    public int getNumberOfOversInTheMatch() {
        return 20;
    }

    @Override
    public int getMaxNumberOfOversAllowedByBowler() {
        return 4;
    }
    
}
