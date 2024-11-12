package BridgeDesignPattern;

import BridgeDesignPattern.BreathImplementors.LandBreathImplementor;
import BridgeDesignPattern.BreathImplementors.MarsBreathImplementor;
import BridgeDesignPattern.BreathImplementors.TreeBreathImplementor;
import BridgeDesignPattern.LivingThings.Dog;
import BridgeDesignPattern.LivingThings.Fish;
import BridgeDesignPattern.LivingThings.LivingThings;
import BridgeDesignPattern.LivingThings.Tree;

public class Driver {
    public static void main(String[] args) {
        LivingThings dog = new Dog(new LandBreathImplementor());
        dog.breathProcess();

        LivingThings dolphin = new Fish(new MarsBreathImplementor());
        dolphin.breathProcess();

        LivingThings banyanTree = new Tree(new TreeBreathImplementor());
        banyanTree.breathProcess();
    }
}
