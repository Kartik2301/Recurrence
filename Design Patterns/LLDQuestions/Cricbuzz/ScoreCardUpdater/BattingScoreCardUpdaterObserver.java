package LLDQuestions.Cricbuzz.ScoreCardUpdater;

import LLDQuestions.Cricbuzz.Ball.Ball;

public class BattingScoreCardUpdaterObserver implements ScoreCardUpdaterObserver {

    @Override
    public void update(Ball ball) {
        System.out.println("Batter: " + ball.getFacedBy().getPerson().getName() + 
                           "\nOutcome: " + ball.getRunType().value);
        ball.getFacedBy().getBattingScorecard().setRuns(ball.getRunType().value);
    }
    
}
