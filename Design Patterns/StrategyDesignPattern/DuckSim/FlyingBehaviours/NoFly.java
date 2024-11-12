package StrategyDesignPattern.DuckSim.FlyingBehaviours;

public class NoFly implements FlyingBehaviour {

    @Override
    public void fly() {
        System.out.println("This duck cannot fly");
    }
    
}
