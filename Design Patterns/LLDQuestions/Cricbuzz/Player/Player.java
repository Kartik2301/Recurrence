package LLDQuestions.Cricbuzz.Player;

import LLDQuestions.Cricbuzz.Scorecards.BattingScorecard;
import LLDQuestions.Cricbuzz.Scorecards.BowlingScorecard;

public class Player {
    private Person person;
    private PlayerType playerType;
    private BattingScorecard battingScorecard;
    private BowlingScorecard bowlingScorecard;

    public Player(Person person, PlayerType playerType, BattingScorecard battingScorecard, BowlingScorecard bowlingScorecard) {
        this.person = person;
        this.playerType = playerType;
        this.battingScorecard = battingScorecard;
        this.bowlingScorecard = bowlingScorecard;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public BattingScorecard getBattingScorecard() {
        return battingScorecard;
    }

    public void setBattingScorecard(BattingScorecard battingScorecard) {
        this.battingScorecard = battingScorecard;
    }

    public BowlingScorecard getBowlingScorecard() {
        return bowlingScorecard;
    }

    public void setBowlingScorecard(BowlingScorecard bowlingScorecard) {
        this.bowlingScorecard = bowlingScorecard;
    }

    
    
}
