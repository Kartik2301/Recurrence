package LLDQuestions.TicTacToe.Revision2.TicTacToe.Pieces;

import LLDQuestions.TicTacToe.Revision2.TicTacToe.PieceType;

public abstract class PlayingPiece {
    PieceType pieceType;

    public PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
