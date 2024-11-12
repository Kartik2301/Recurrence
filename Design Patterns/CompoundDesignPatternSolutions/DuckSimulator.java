package CompoundDesignPatternSolutions;

import CompoundDesignPatternSolutions.Factories.AbstractDuckFactory;
import CompoundDesignPatternSolutions.Factories.CountingDuckFactory;
import CompoundDesignPatternSolutions.Flock.Flock;
import CompoundDesignPatternSolutions.Goose.Goose;
import CompoundDesignPatternSolutions.Goose.GooseAdapter;
import CompoundDesignPatternSolutions.Observer.Observer;
import CompoundDesignPatternSolutions.Observer.Quackologist;
import CompoundDesignPatternSolutions.QuackCounter.QuackCounter;
import CompoundDesignPatternSolutions.Quackable.Quackable;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory abstractDuckFactory = new CountingDuckFactory();
        duckSimulator.simulate(abstractDuckFactory);
    }

    private void simulate(AbstractDuckFactory duckFactory) {
        Observer quackologist = new Quackologist();
         
        Quackable redheadDuck = duckFactory.createReadheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        Quackable mallardDuck1 = duckFactory.createMallardDuck();
        Quackable mallardDuck2 = duckFactory.createMallardDuck();
        Quackable mallardDuck3 = duckFactory.createMallardDuck();
        Quackable mallardDuck4 = duckFactory.createMallardDuck();

        Flock flockOfMallardDucks = new Flock();
        flockOfMallardDucks.add(mallardDuck1);
        flockOfMallardDucks.add(mallardDuck2);
        flockOfMallardDucks.add(mallardDuck3);
        flockOfMallardDucks.add(mallardDuck4);
        
        flockOfDucks.add(flockOfMallardDucks);
        flockOfDucks.registerObserver(quackologist);

        System.out.println("\nDuck Simulation: Whole Flock Simulation");
        simulate(flockOfDucks);
    
        // System.out.println("\nDuck Simulation: Mallard Flock Simulation");
        // simulate(flockOfMallardDucks);

        System.out.println("Total Quack Count is: " + QuackCounter.getQuackCount());
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}
