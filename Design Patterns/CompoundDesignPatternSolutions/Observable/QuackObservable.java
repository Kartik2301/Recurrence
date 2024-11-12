package CompoundDesignPatternSolutions.Observable;

import CompoundDesignPatternSolutions.Observer.Observer;

public interface QuackObservable {
    public void registerObserver(Observer observer);
    public void notifyObservers();
}
