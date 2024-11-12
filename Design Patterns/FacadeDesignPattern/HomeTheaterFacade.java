package FacadeDesignPattern;

import FacadeDesignPattern.HomeTheaterSubSystem.PopcornMachine;
import FacadeDesignPattern.HomeTheaterSubSystem.Projector;
import FacadeDesignPattern.HomeTheaterSubSystem.SoundSystem;
import FacadeDesignPattern.HomeTheaterSubSystem.StreamingSystem;
import FacadeDesignPattern.HomeTheaterSubSystem.TheaterLightsController;

public class HomeTheaterFacade {
    private PopcornMachine popcornMachine;
    private Projector projector;
    private SoundSystem soundSystem;
    private StreamingSystem streamingSystem;
    private TheaterLightsController theaterLightsController;

    public HomeTheaterFacade(PopcornMachine popcornMachine, Projector projector, SoundSystem soundSystem,
                             StreamingSystem streamingSystem, TheaterLightsController theaterLightsController) {
        this.popcornMachine = popcornMachine;
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.streamingSystem = streamingSystem;
        this.theaterLightsController = theaterLightsController;
    }

    public void watchMovie() {
        popcornMachine.turnOn();
        streamingSystem.startStreaming("Inception");
        projector.startProjecting();
        soundSystem.setVolume(10);
        theaterLightsController.dimLights();
    }

    public void stopMovie() {
        popcornMachine.turnOff();
        streamingSystem.stopStreaming();
        projector.endProjecting();
        soundSystem.setVolume(0);
        theaterLightsController.lightOn();
    }
}
