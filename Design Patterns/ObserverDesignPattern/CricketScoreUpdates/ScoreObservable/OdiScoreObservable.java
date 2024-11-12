package ObserverDesignPattern.CricketScoreUpdates.ScoreObservable;

import java.util.ArrayList;
import java.util.List;

import ObserverDesignPattern.CricketScoreUpdates.ScoreObserver.ScoreObserver;

public class OdiScoreObservable implements ScoreObservable {
    private List<ScoreObserver> observers;
    private int runs;
    private int wickets;

    public OdiScoreObservable() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(ScoreObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ScoreObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(ScoreObserver observer: observers) {
            observer.update();
        }
    }

    @Override
    public void setScore(int runs, int wickets) {
        this.runs = runs;
        this.wickets = wickets;
        notifyObservers();
    }

    @Override
    public String getScore() {
        return runs + "/" + wickets;
    }

}
