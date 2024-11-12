package BridgeDesignPattern.LivingThings;

import BridgeDesignPattern.BreathImplementors.BreathImplementor;

public class Dog extends LivingThings {

    public Dog(BreathImplementor breathImplementor) {
        super(breathImplementor);
    }

    @Override
    public void breathProcess() {
        breathImplementor.breath();
    }
    
}
