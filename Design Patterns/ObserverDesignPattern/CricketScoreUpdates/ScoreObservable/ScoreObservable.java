package ObserverDesignPattern.CricketScoreUpdates.ScoreObservable;

import ObserverDesignPattern.CricketScoreUpdates.ScoreObserver.ScoreObserver;

public interface ScoreObservable {
    public void addObserver(ScoreObserver observer);
    public void removeObserver(ScoreObserver observer);
    public void notifyObservers();
    public void setScore(int runs, int wickets);
    public String getScore();
}
