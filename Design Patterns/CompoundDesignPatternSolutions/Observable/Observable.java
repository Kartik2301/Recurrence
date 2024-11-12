package CompoundDesignPatternSolutions.Observable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import CompoundDesignPatternSolutions.Observer.Observer;
import CompoundDesignPatternSolutions.Quackable.Quackable;

public class Observable implements QuackObservable {
    private List<Observer> observers;
    private Quackable duck;

    public Observable(Quackable duck) {
        observers = new ArrayList<>();
        this.duck = duck;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while(iterator.hasNext()) {
            iterator.next().update(duck);
        }
    }
}
