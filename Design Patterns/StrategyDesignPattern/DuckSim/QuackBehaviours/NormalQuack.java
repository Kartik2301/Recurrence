package StrategyDesignPattern.DuckSim.QuackBehaviours;

public class NormalQuack implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("Normal Quack-Quack");
    }
    
}
