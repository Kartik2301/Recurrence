package StrategyDesignPattern.DuckSim.Ducks;

import StrategyDesignPattern.DuckSim.FlyingBehaviours.FlyingBehaviour;
import StrategyDesignPattern.DuckSim.QuackBehaviours.QuackBehaviour;

public class ModelDuck extends Duck {
    public ModelDuck(FlyingBehaviour flyingBehaviour, QuackBehaviour quackBehaviour) {
        super(flyingBehaviour, quackBehaviour);
    }
}
