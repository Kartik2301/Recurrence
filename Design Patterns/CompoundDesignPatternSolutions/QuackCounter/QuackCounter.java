package CompoundDesignPatternSolutions.QuackCounter;

import CompoundDesignPatternSolutions.Observer.Observer;
import CompoundDesignPatternSolutions.Quackable.Quackable;

public class QuackCounter implements Quackable {
    private Quackable duck;
    private static int quackCount;

    public QuackCounter(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();
        quackCount++;
    }

    public static int getQuackCount() {
        return quackCount;
    }

    @Override
    public void registerObserver(Observer observer) {
        duck.registerObserver(observer);
    }

    @Override
    public void notifyObservers() {
        duck.notifyObservers();
    }

}
