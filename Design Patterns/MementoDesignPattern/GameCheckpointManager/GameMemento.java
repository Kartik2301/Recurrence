package MementoDesignPattern.GameCheckpointManager;

import java.util.List;

public class GameMemento {
    private int currentLevel;
    private List<String> weaponsUnlocked;
    private List<String> vehiclesUnlocked;

    public GameMemento(int currentLevel, List<String> weaponsUnlocked, List<String> vehiclesUnlocked) {
        this.currentLevel = currentLevel;
        this.weaponsUnlocked = weaponsUnlocked;
        this.vehiclesUnlocked = vehiclesUnlocked;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public List<String> getWeaponsUnlocked() {
        return weaponsUnlocked;
    }

    public List<String> getVehiclesUnlocked() {
        return vehiclesUnlocked;
    }
}
