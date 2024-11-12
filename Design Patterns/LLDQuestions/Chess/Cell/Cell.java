package LLDQuestions.Chess.Cell;

import LLDQuestions.Chess.Color;
import LLDQuestions.Chess.Piece.Piece;

public class Cell {
    private Piece piece;
    private Color color;
    private int cellID;

    public Cell(int cellID, Color color) {
        this.cellID = cellID;
        this.color = color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Color getColor() {
        return color;
    }
    
    public int getCellID() {
        return cellID;
    }
    
}
