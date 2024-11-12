package MementoDesignPattern.GameCheckpointManager;

import java.util.List;

public class Game {
    public int currentLevel;
    private List<String> weaponsUnlocked;
    private List<String> vehiclesUnlocked;

    public Game(int currentLevel, List<String> weaponsUnlocked, List<String> vehiclesUnlocked) {
        this.currentLevel = currentLevel;
        this.weaponsUnlocked = weaponsUnlocked;
        this.vehiclesUnlocked = vehiclesUnlocked;
    }

    // Game Methods
    public GameMemento createCheckpoint() {
        return new GameMemento(currentLevel, weaponsUnlocked, vehiclesUnlocked);
    }

    public void restoreCheckpoint(GameMemento gameMemento) {
        this.currentLevel = gameMemento.getCurrentLevel();
        this.weaponsUnlocked = gameMemento.getWeaponsUnlocked();
        this.vehiclesUnlocked = gameMemento.getVehiclesUnlocked();
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public void setWeaponsUnlocked(List<String> weaponsUnlocked) {
        this.weaponsUnlocked = weaponsUnlocked;
    }

    public void setVehiclesUnlocked(List<String> vehiclesUnlocked) {
        this.vehiclesUnlocked = vehiclesUnlocked;
    }

    public void printCurrentGameState() {
        System.out.println("Current Level is: " + this.currentLevel);
        System.out.println("Current Weapons Unlocked");
        for(String weapon: this.weaponsUnlocked) {
            System.out.print(weapon + ", ");
        }
        System.out.println();
        System.out.println("Current Vehicles Unlocked");
        for(String vehicle: this.vehiclesUnlocked) {
            System.out.print(vehicle + ", ");
        }
        System.out.println();
    }
}
