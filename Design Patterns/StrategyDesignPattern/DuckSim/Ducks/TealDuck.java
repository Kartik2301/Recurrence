package StrategyDesignPattern.DuckSim.Ducks;

import StrategyDesignPattern.DuckSim.FlyingBehaviours.FlyingBehaviour;
import StrategyDesignPattern.DuckSim.QuackBehaviours.QuackBehaviour;

public class TealDuck extends Duck {

    public TealDuck(FlyingBehaviour flyingBehaviour, QuackBehaviour quackBehaviour) {
        super(flyingBehaviour, quackBehaviour);
    }
    
}
