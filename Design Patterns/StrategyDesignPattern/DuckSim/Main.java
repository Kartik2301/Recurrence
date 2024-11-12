package StrategyDesignPattern.DuckSim;

import StrategyDesignPattern.DuckSim.Ducks.Duck;
import StrategyDesignPattern.DuckSim.Ducks.MallardDuck;
import StrategyDesignPattern.DuckSim.Ducks.ModelDuck;
import StrategyDesignPattern.DuckSim.FlyingBehaviours.HighSpeedTurboFly;
import StrategyDesignPattern.DuckSim.FlyingBehaviours.NoFly;
import StrategyDesignPattern.DuckSim.FlyingBehaviours.NormalFlyWithWings;
import StrategyDesignPattern.DuckSim.QuackBehaviours.HighPitchedQuacking;
import StrategyDesignPattern.DuckSim.QuackBehaviours.MuteQuack;
import StrategyDesignPattern.DuckSim.QuackBehaviours.NormalQuack;

public class Main {
    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck(new NormalFlyWithWings(), new NormalQuack());
        mallardDuck.performFly();
        mallardDuck.performQuack();

        Duck modelDuck = new ModelDuck(new NoFly(), new MuteQuack());
        modelDuck.performFly();
        modelDuck.performQuack();

        modelDuck.setFlyingBehaviour(new HighSpeedTurboFly());
        modelDuck.setQuackBehaviour(new HighPitchedQuacking());
        modelDuck.performFly();
        modelDuck.performQuack();
    }
}
