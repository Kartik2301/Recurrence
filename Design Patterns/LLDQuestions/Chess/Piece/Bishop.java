package LLDQuestions.Chess.Piece;

import LLDQuestions.Chess.Color;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public boolean isAValidMove(int srcX, int srcY, int dstX, int dstY, int n) {
        if(srcX + srcY == dstX + dstY) return true;
        if(srcX + (n - srcY) == dstX + (n - dstY)) return true;
        return false;
    }
    
}
