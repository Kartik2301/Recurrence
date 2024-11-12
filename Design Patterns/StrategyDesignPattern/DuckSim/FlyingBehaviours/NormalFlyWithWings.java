package StrategyDesignPattern.DuckSim.FlyingBehaviours;

public class NormalFlyWithWings implements FlyingBehaviour {

    @Override
    public void fly() {
        System.out.println("Normal Fly Behaviour");
    }
    
}
