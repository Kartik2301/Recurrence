package LLDQuestions.Chess.Piece;

import LLDQuestions.Chess.Color;

public class Knight extends Piece {

    public Knight(Color color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    public boolean isAValidMove(int srcX, int srcY, int dstX, int dstY, int n) {
        int xMoves[] = {1, 1, -1, -1, 2, 2, -2, -2};
        int yMoves[] = {2, -2, -2, 2, -1, 1, -1, 1};

        for(int index = 0; index < xMoves.length; index++) {
            int newX = srcX + xMoves[index];
            int newY = srcY + yMoves[index];

            if(newX == dstX && newY == dstY) {
                return true;
            }
        }

        return false;
    }
    
}
