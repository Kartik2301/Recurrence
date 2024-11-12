package LLDQuestions.Cricbuzz.ScoreCardUpdater;

import LLDQuestions.Cricbuzz.Ball.Ball;

public interface ScoreCardUpdaterObserver {
    public void update(Ball ball);
}
