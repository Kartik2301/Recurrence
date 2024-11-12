package CompoundDesignPatternSolutions.Flock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import CompoundDesignPatternSolutions.Observer.Observer;
import CompoundDesignPatternSolutions.Quackable.Quackable;

public class Flock implements Quackable {
    private List<Quackable> quackables;

    public Flock() {
        quackables = new ArrayList<>();
    }

    public void add(Quackable quackable) {
        quackables.add(quackable);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackables.iterator();
        while (iterator.hasNext()) {
            iterator.next().quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator<Quackable> iterator = quackables.iterator();
        while (iterator.hasNext()) {
            iterator.next().registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
        Iterator<Quackable> iterator = quackables.iterator();
        while (iterator.hasNext()) {
            iterator.next().notifyObservers();
        }
    }
    
}
