package ObserverDesignPattern.CricketScoreUpdates.ScoreObserver;

import ObserverDesignPattern.CricketScoreUpdates.ScoreObservable.ScoreObservable;

public class IPhoneScoreObserver implements ScoreObserver {
    ScoreObservable scoreObservable;

    public IPhoneScoreObserver(ScoreObservable scoreObservable) {
        this.scoreObservable = scoreObservable;
    }

    @Override
    public void update() {
        String score = this.scoreObservable.getScore();
        sendPushNotification(score);
    }

    private void sendPushNotification(String score) {
        System.out.println("PUSH-NOTIFICATION: score: " + score);
    }
    
}
