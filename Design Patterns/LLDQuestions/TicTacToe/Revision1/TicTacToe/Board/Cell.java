package LLDQuestions.TicTacToe.Revision1.TicTacToe.Board;

import LLDQuestions.TicTacToe.Revision1.TicTacToe.Piece.Piece;

public class Cell {
    private int cellID;
    private Piece piece;

    public Cell(int cellId) {
        this.cellID = cellId;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
