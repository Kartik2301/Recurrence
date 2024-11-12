package StrategyDesignPattern.DuckSim.QuackBehaviours;

public class MuteQuack implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("Silence");
    }
    
}
