package StrategyDesignPattern.DuckSim.QuackBehaviours;

public class HighPitchedQuacking implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("Quacking at 1000DB");
    }
    
}
