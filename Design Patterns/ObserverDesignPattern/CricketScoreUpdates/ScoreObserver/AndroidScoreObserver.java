package ObserverDesignPattern.CricketScoreUpdates.ScoreObserver;

import ObserverDesignPattern.CricketScoreUpdates.ScoreObservable.ScoreObservable;

public class AndroidScoreObserver implements ScoreObserver {
    private ScoreObservable scoreObservable;

    public AndroidScoreObserver(ScoreObservable scoreObservable) {
        this.scoreObservable = scoreObservable;
    }

    @Override
    public void update() {
        String score = this.scoreObservable.getScore();
        sendEmailNotification(score);
    }

    private void sendEmailNotification(String score) {
        System.out.println("EMAIL-NOTIFICATION: score: " + score);
    }
    
}
