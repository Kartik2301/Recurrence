package LLDQuestions.Chess.Piece;

import LLDQuestions.Chess.Color;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(PieceType.PAWN, color);
    }

    @Override
    public boolean isAValidMove(int srcX, int srcY, int dstX, int dstY, int n) {
        if(srcX == dstX && dstY == srcY + 1) return true;
        return false;
    }
    
}
