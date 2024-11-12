package LLDQuestions.Chess.Piece;

import LLDQuestions.Chess.Color;

public class King extends Piece {

    public King(Color color) {
        super(PieceType.KING, color);
    }

    @Override
    public boolean isAValidMove(int srcX, int srcY, int dstX, int dstY, int n) {
        int xMoves[] = {1, -1, 1, -1, 1, -1, 0, 0};
        int yMoves[] = {1, -1, -1, 1, 0, 0, 1, -1};

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
