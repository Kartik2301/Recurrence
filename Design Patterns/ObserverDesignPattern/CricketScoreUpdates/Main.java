package ObserverDesignPattern.CricketScoreUpdates;

import java.util.Random;

import ObserverDesignPattern.CricketScoreUpdates.ScoreObservable.OdiScoreObservable;
import ObserverDesignPattern.CricketScoreUpdates.ScoreObservable.ScoreObservable;
import ObserverDesignPattern.CricketScoreUpdates.ScoreObserver.AndroidScoreObserver;
import ObserverDesignPattern.CricketScoreUpdates.ScoreObserver.IPhoneScoreObserver;
import ObserverDesignPattern.CricketScoreUpdates.ScoreObserver.ScoreObserver;
import ObserverDesignPattern.CricketScoreUpdates.ScoreObserver.WebScoreObserver;

public class Main {
    public static void main(String[] args) {
        ScoreObservable scoreObservable = new OdiScoreObservable();

        ScoreObserver androidObserver = new AndroidScoreObserver(scoreObservable);
        ScoreObserver iphoneObserver = new IPhoneScoreObserver(scoreObservable);
        ScoreObserver webObserver = new WebScoreObserver(scoreObservable);

        scoreObservable.addObserver(webObserver);
        scoreObservable.addObserver(iphoneObserver);
        scoreObservable.addObserver(androidObserver);
        
        int runs = 245;
        int wickets = 4;
        Random random = new Random();
        
        for(int i = 0; i < 6; i++) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

            runs += random.nextInt(7);

            scoreObservable.setScore(runs, wickets);
        }
    }
}
