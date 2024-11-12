package LLDQuestions.Chess.PieceFactory;

import LLDQuestions.Chess.Color;
import LLDQuestions.Chess.Piece.Bishop;
import LLDQuestions.Chess.Piece.King;
import LLDQuestions.Chess.Piece.Knight;
import LLDQuestions.Chess.Piece.Pawn;
import LLDQuestions.Chess.Piece.Piece;
import LLDQuestions.Chess.Piece.Queen;
import LLDQuestions.Chess.Piece.Rock;

public class BlackPieceFactory extends PieceAbstractFactory {

    @Override
    public Piece getPawn() {
        return new Pawn(Color.BLACK);
    }

    @Override
    public Piece getRock() {
        return new Rock(Color.BLACK);
    }

    @Override
    public Piece getKing() {
        return new King(Color.BLACK);
    }

    @Override
    public Piece getQueen() {
        return new Queen(Color.BLACK);
    }

    @Override
    public Piece getBishop() {
        return new Bishop(Color.BLACK);
    }

    @Override
    public Piece getKnight() {
        return new Knight(Color.BLACK);
    }
    
}
