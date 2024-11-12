package ObserverDesignPattern.CricketScoreUpdates.ScoreObserver;

import ObserverDesignPattern.CricketScoreUpdates.ScoreObservable.ScoreObservable;

public class WebScoreObserver implements ScoreObserver {
    ScoreObservable scoreObservable;

    public WebScoreObserver(ScoreObservable scoreObservable) {
        this.scoreObservable = scoreObservable;
    }

    @Override
    public void update() {
        String score = this.scoreObservable.getScore();
        display(score);
    }
    
    private void display(String score) {
        System.out.println("Current Score is: " + score);
    }
}
