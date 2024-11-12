package FacadeDesignPattern.HomeTheaterSubSystem;

public class StreamingSystem {
    public void startStreaming(String movieName) {
        System.out.println("Starting the screening of: " + movieName);
    }

    public void stopStreaming() {
        System.out.println("Currently running movie has been stopped");
    }
}
