package CompoundDesignPatternSolutions.Factories;

import CompoundDesignPatternSolutions.Duck.DuckCall;
import CompoundDesignPatternSolutions.Duck.MallardDuck;
import CompoundDesignPatternSolutions.Duck.RedheadDuck;
import CompoundDesignPatternSolutions.Duck.RubberDuck;
import CompoundDesignPatternSolutions.Quackable.Quackable;

public class DuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createReadheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }
    
}
