package LLDQuestions.Cricbuzz.ScoreCardUpdater;

import LLDQuestions.Cricbuzz.Ball.Ball;

public class BowlingScoreCardUpdaterObserver implements ScoreCardUpdaterObserver {

    @Override
    public void update(Ball ball) {
        System.out.println("Bowler: " +  ball.getBowledBy().getPerson().getName() + 
                           "\nOutcome: " + ball.getRunType().value);
    }
    
}
