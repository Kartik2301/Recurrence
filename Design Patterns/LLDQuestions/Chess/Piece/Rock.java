package LLDQuestions.Chess.Piece;

import LLDQuestions.Chess.Color;

public class Rock extends Piece {

    public Rock(Color color) {
        super(PieceType.ROCK, color);
    }

    @Override
    public boolean isAValidMove(int srcX, int srcY, int dstX, int dstY, int n) {
        if((srcX == dstX) && (srcY == dstY)) return false;
        if((srcX == dstX) || (srcY == dstY)) return true;
        return false;
    }

}
