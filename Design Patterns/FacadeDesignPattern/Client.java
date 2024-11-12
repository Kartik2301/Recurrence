package FacadeDesignPattern;

import FacadeDesignPattern.HomeTheaterSubSystem.PopcornMachine;
import FacadeDesignPattern.HomeTheaterSubSystem.Projector;
import FacadeDesignPattern.HomeTheaterSubSystem.SoundSystem;
import FacadeDesignPattern.HomeTheaterSubSystem.StreamingSystem;
import FacadeDesignPattern.HomeTheaterSubSystem.TheaterLightsController;

public class Client {
    public static void main(String[] args) {
        HomeTheaterFacade theater = new HomeTheaterFacade(new PopcornMachine(),
                                                          new Projector(), 
                                                          new SoundSystem(),
                                                          new StreamingSystem(),
                                                          new TheaterLightsController());
        
        theater.watchMovie();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        theater.stopMovie();
    }
}
