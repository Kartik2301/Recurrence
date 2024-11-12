package MementoDesignPattern.GameCheckpointManager;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        GameCareTaker careTaker = new GameCareTaker();
        List<String> weapons = new ArrayList<>();
        List<String> vehicles = new ArrayList<>();

        weapons.add("Knife");
        vehicles.add("Cycle");

        Game game = new Game(1, weapons, vehicles);
        careTaker.addState(game.createCheckpoint());
        game.printCurrentGameState();

        weapons.add("Gun");
        vehicles.add("Bike");

        game.setCurrentLevel(2);
        game.setVehiclesUnlocked(vehicles);
        game.setWeaponsUnlocked(weapons);
        careTaker.addState(game.createCheckpoint());
        game.printCurrentGameState();

        weapons.add("Mortar");
        vehicles.add("Car");

        game.setCurrentLevel(3);
        game.setVehiclesUnlocked(vehicles);
        game.setWeaponsUnlocked(weapons);
        careTaker.addState(game.createCheckpoint());
        game.printCurrentGameState();

        weapons.add("Army Tank");
        vehicles.add("Rocket");

        game.setVehiclesUnlocked(vehicles);
        game.setWeaponsUnlocked(weapons);
        game.printCurrentGameState();

        // Go Back!!
        game.restoreCheckpoint(careTaker.undo());
        game.restoreCheckpoint(careTaker.undo());
        game.printCurrentGameState();
    }
}
