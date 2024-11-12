package LLDQuestions.SnakeAndLadder.Revision2;

import LLDQuestions.SnakeAndLadder.Revision2.Movables.Piece;

public class Player {
    private String userName;
    private Piece piece;
    private int position;

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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
