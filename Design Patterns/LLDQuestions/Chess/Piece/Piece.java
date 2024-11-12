package LLDQuestions.Chess.Piece;

import LLDQuestions.Chess.Color;

public abstract class Piece {
    private PieceType pieceType;
    private Color color;

    public Piece(PieceType pieceType, Color color) {
        this.pieceType = pieceType;
        this.color = color;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Color getColor() {
        return color;
    }

    public abstract boolean isAValidMove(int srcX, int srcY, int dstX, int dstY, int n);

    @Override
    public String toString() {
        return "Piece: " + pieceType.name() + ", Color: " + color.name();
    }
}
