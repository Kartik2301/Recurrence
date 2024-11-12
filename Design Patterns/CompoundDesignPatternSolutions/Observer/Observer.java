package CompoundDesignPatternSolutions.Observer;

import CompoundDesignPatternSolutions.Observable.QuackObservable;

public interface Observer {
    public void update(QuackObservable quackObservable);
}
