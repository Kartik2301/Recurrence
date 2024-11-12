package StrategyDesignPattern.DuckSim.FlyingBehaviours;

public class HighSpeedTurboFly implements FlyingBehaviour {

    @Override
    public void fly() {
        System.out.println("Very High Speed Flying");
    }
    
}
