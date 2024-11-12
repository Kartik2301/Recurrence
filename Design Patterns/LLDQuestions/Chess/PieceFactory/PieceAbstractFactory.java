package LLDQuestions.Chess.PieceFactory;

import LLDQuestions.Chess.Piece.Piece;

public abstract class PieceAbstractFactory {
    public abstract Piece getPawn();
    public abstract Piece getRock();
    public abstract Piece getKing();
    public abstract Piece getQueen();
    public abstract Piece getBishop();
    public abstract Piece getKnight();
}
