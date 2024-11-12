package MementoDesignPattern.GameCheckpointManager;

import java.util.Stack;

public class GameCareTaker {
    private Stack<GameMemento> gameStates;

    public GameCareTaker() {
        gameStates = new Stack<>();
    }

    public void addState(GameMemento memento) {
        gameStates.push(memento);
    }

    public GameMemento undo() {
        if(gameStates.isEmpty()) return null;
        GameMemento lastSavedState = gameStates.pop();
        lastSavedState.getVehiclesUnlocked().removeLast();
        lastSavedState.getWeaponsUnlocked().removeLast();
        return lastSavedState;
    }
}
