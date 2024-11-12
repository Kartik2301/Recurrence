package LLDQuestions.SnakeAndLadder.Revision2.Board;

import LLDQuestions.SnakeAndLadder.Revision2.Movables.Piece;
import LLDQuestions.SnakeAndLadder.Revision2.Movables.PositionChangers;

public class Cell {
    private Piece piece;
    private PositionChangers positionChanger;
    private int position;

    public Cell() {
        this.piece = null;
        this.positionChanger = null;
    }


    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public PositionChangers getPositionChanger() {
        return positionChanger;
    }

    public void setPositionChanger(PositionChangers positionChangers) {
        this.positionChanger = positionChangers;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
