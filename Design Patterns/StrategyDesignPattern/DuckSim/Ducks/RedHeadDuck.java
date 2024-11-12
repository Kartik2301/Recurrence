package StrategyDesignPattern.DuckSim.Ducks;

import StrategyDesignPattern.DuckSim.FlyingBehaviours.FlyingBehaviour;
import StrategyDesignPattern.DuckSim.QuackBehaviours.QuackBehaviour;

public class RedHeadDuck extends Duck {

    public RedHeadDuck(FlyingBehaviour flyingBehaviour, QuackBehaviour quackBehaviour) {
        super(flyingBehaviour, quackBehaviour);
    }
    
}
