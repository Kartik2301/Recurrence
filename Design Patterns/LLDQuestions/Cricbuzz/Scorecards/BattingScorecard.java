package LLDQuestions.Cricbuzz.Scorecards;

public class BattingScorecard {
    private int runs;
    private int bowls;
    private int fours;
    private int sixes;
    private double strikeRate;

    public BattingScorecard() {
        runs = bowls = fours = sixes = -1;
        strikeRate = 0;
    }

    public int getRuns() {
        return runs;
    }
    public void setRuns(int runsDelta) {
        if(this.runs == -1) {
            this.runs = 0;
        }
        this.runs += runsDelta;
    }
    public int getBowls() {
        return bowls;
    }
    public void setBowls(int bowls) {
        this.bowls = bowls;
    }
    public int getFours() {
        return fours;
    }
    public void setFours(int fours) {
        this.fours = fours;
    }
    public int getSixes() {
        return sixes;
    }
    public void setSixes(int sixes) {
        this.sixes = sixes;
    }
    public double getStrikeRate() {
        return strikeRate;
    }
    public void setStrikeRate(double strikeRate) {
        this.strikeRate = strikeRate;
    }

    
}
