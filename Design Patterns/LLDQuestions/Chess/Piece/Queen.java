package LLDQuestions.Chess.Piece;

import LLDQuestions.Chess.Color;

public class Queen extends Piece {

    public Queen(Color color) {
        super(PieceType.QUEEN, color);
    }

    @Override
    public boolean isAValidMove(int srcX, int srcY, int dstX, int dstY, int n) {
        if((srcX == dstX) || (srcY == dstY)) return true;
        if(srcX + srcY == dstX + dstY) return true;
        if(srcX + (n - srcY) == dstX + (n - dstY)) return true;
        return false;
    }
    
}
