package CompoundDesignPatternSolutions.Factories;

import CompoundDesignPatternSolutions.Duck.DuckCall;
import CompoundDesignPatternSolutions.Duck.MallardDuck;
import CompoundDesignPatternSolutions.Duck.RedheadDuck;
import CompoundDesignPatternSolutions.Duck.RubberDuck;
import CompoundDesignPatternSolutions.QuackCounter.QuackCounter;
import CompoundDesignPatternSolutions.Quackable.Quackable;

public class CountingDuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    public Quackable createReadheadDuck() {
        return new QuackCounter(new RedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
    
}
