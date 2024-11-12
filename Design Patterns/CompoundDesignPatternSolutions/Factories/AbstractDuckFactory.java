package CompoundDesignPatternSolutions.Factories;

import CompoundDesignPatternSolutions.Quackable.Quackable;

public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();
    public abstract Quackable createReadheadDuck();
    public abstract Quackable createDuckCall();
    public abstract Quackable createRubberDuck();
}
