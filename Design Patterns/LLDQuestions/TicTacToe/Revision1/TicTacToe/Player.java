package LLDQuestions.TicTacToe.Revision1.TicTacToe;

import LLDQuestions.TicTacToe.Revision1.TicTacToe.Piece.Piece;

public class Player {
    private String userName;
    private Piece piece;

    public Player(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
}
