package StrategyDesignPattern.DuckSim.Ducks;

import StrategyDesignPattern.DuckSim.FlyingBehaviours.FlyingBehaviour;
import StrategyDesignPattern.DuckSim.QuackBehaviours.QuackBehaviour;

public class MallardDuck extends Duck {
    public MallardDuck(FlyingBehaviour flyingBehaviour, QuackBehaviour quackBehaviour) {
        super(flyingBehaviour, quackBehaviour);
    }
}
