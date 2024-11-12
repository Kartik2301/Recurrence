package MementoDesignPattern.ConfigurationManager;


import java.util.Stack;

public class CareTaker {
    private Stack<ConfigurationMemento> history;

    public CareTaker() {
        this.history = new Stack<>();
    }

    public void addMemento(ConfigurationMemento configurationMemento) {
        this.history.add(configurationMemento);
    }

    public ConfigurationMemento undo() {
        if(history.isEmpty()) {
            return new ConfigurationMemento(0, 0);
        }
        return history.pop();
    }
}
