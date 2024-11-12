package BridgeDesignPattern.LivingThings;

import BridgeDesignPattern.BreathImplementors.BreathImplementor;

public abstract class LivingThings {
    BreathImplementor breathImplementor;

    public LivingThings(BreathImplementor breathImplementor) {
        this.breathImplementor = breathImplementor;
    }

    public abstract void breathProcess();
}
