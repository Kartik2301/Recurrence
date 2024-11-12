package BridgeDesignPattern.LivingThings;

import BridgeDesignPattern.BreathImplementors.BreathImplementor;

public class Tree extends LivingThings {

    public Tree(BreathImplementor breathImplementor) {
        super(breathImplementor);
    }

    @Override
    public void breathProcess() {
        breathImplementor.breath();
    }
    
}
