package StrategyDesignPattern.DuckSim.Ducks;

import StrategyDesignPattern.DuckSim.FlyingBehaviours.FlyingBehaviour;
import StrategyDesignPattern.DuckSim.QuackBehaviours.QuackBehaviour;

public abstract class Duck {
    FlyingBehaviour flyingBehaviour;
    QuackBehaviour quackBehaviour;

    public Duck(FlyingBehaviour flyingBehaviour, QuackBehaviour quackBehaviour) {
        this.flyingBehaviour = flyingBehaviour;
        this.quackBehaviour = quackBehaviour;
    }

    public void performFly() {
        flyingBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack();
    }

    public void setFlyingBehaviour(FlyingBehaviour flyingBehaviour) {
        this.flyingBehaviour = flyingBehaviour;
    }

    public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

    public void swim() {
        System.out.println("All Ducks can swim");
    }

}
