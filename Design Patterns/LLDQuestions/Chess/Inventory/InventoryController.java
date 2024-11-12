package LLDQuestions.Chess.Inventory;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.Chess.Piece.Piece;
import LLDQuestions.Chess.PieceFactory.PieceAbstractFactory;

public class InventoryController {
    private Inventory inventory;

    public InventoryController() {
        inventory = new Inventory();
    }

    public void setupInventory(PieceAbstractFactory pieceAbstractFactory) {
        inventory.setKing(pieceAbstractFactory.getKing());
        inventory.setQueen(pieceAbstractFactory.getQueen());

        List<Piece> knights = new ArrayList<>();
        knights.add(pieceAbstractFactory.getKnight());
        knights.add(pieceAbstractFactory.getKnight());

        List<Piece> bishops = new ArrayList<>();
        bishops.add(pieceAbstractFactory.getBishop());
        bishops.add(pieceAbstractFactory.getBishop());

        List<Piece> rocks = new ArrayList<>();
        rocks.add(pieceAbstractFactory.getRock());
        rocks.add(pieceAbstractFactory.getRock());

        List<Piece> pawns = new ArrayList<>();
        for(int count = 0; count < 8; count++) {
            pawns.add(pieceAbstractFactory.getPawn());
        }
        
        inventory.setKnights(knights);
        inventory.setBishops(bishops);
        inventory.setRocks(rocks);
        inventory.setPawns(pawns);
    }
    
    public void displayInvetory() {
        System.out.println(inventory.getKing());
        System.out.println(inventory.getQueen());

        System.out.println(inventory.getRocks().get(0) + " Count: " + inventory.getRocks().size());
        System.out.println(inventory.getBishops().get(0) + " Count: " + inventory.getBishops().size());
        System.out.println(inventory.getKnights().get(0) + " Count: " + inventory.getKnights().size());
        System.out.println(inventory.getPawns().get(0) + " Count: " + inventory.getPawns().size());
    }

    public Inventory getInventory() {
        return inventory;
    }
}
