package CompoundDesignPatternSolutions.Quackable;

import CompoundDesignPatternSolutions.Observable.QuackObservable;

public interface Quackable extends QuackObservable {
    public void quack();
}
