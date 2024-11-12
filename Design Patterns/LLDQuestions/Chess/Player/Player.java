package LLDQuestions.Chess.Player;

import LLDQuestions.Chess.Color;
import LLDQuestions.Chess.Inventory.InventoryController;
import LLDQuestions.Chess.PieceFactory.PieceAbstractFactory;

public class Player {
    private String userName;
    private Color color;
    private InventoryController inventoryController;
    private PieceAbstractFactory pieceAbstractFactory;

    public Player(String userName, Color color, PieceAbstractFactory pieceAbstractFactory) {
        this.userName = userName;
        this.color = color;
        this.pieceAbstractFactory = pieceAbstractFactory;
        this.inventoryController = new InventoryController();
        this.inventoryController.setupInventory(pieceAbstractFactory);
    }

    public void displayInvetory() {
        inventoryController.displayInvetory();
    }

    public String getUserName() {
        return userName;
    }

    public Color getColor() {
        return color;
    }

    public InventoryController getInventoryController() {
        return inventoryController;
    }

}
