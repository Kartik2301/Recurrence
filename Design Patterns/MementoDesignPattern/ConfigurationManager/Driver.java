package MementoDesignPattern.ConfigurationManager;

public class Driver {
    private static void printConfig(ConfigurationOriginator configurationOriginator) {
        System.out.println(configurationOriginator.getHeight() + ", " + configurationOriginator.getWidth());
    }

    private static void undo(ConfigurationOriginator configurationOriginator, CareTaker careTaker) {
        configurationOriginator.restoreMemento(careTaker.undo());
        System.out.println();
        System.out.println("UNDO");
        printConfig(configurationOriginator);
    }

    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();

        ConfigurationOriginator configurationOriginator = new ConfigurationOriginator(4, 5);
        careTaker.addMemento(configurationOriginator.createMemento());
        printConfig(configurationOriginator);

        configurationOriginator.setHeight(12);
        configurationOriginator.setWidth(32);
        careTaker.addMemento(configurationOriginator.createMemento());
        printConfig(configurationOriginator);

        configurationOriginator.setHeight(3);
        configurationOriginator.setWidth(9);
        careTaker.addMemento(configurationOriginator.createMemento());
        printConfig(configurationOriginator);

        configurationOriginator.setHeight(55);
        configurationOriginator.setWidth(16);
        printConfig(configurationOriginator);

        undo(configurationOriginator, careTaker);
        undo(configurationOriginator, careTaker);
        undo(configurationOriginator, careTaker);
        undo(configurationOriginator, careTaker);
    }
}
