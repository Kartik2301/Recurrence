package LLDQuestions.Chess;

import LLDQuestions.Chess.PieceFactory.BlackPieceFactory;
import LLDQuestions.Chess.PieceFactory.PieceAbstractFactory;
import LLDQuestions.Chess.PieceFactory.WhitePieceFactory;

public class PieceFactoryDispatcher {
    public static PieceAbstractFactory createPieceFactory(Color color) {
        switch (color) {
            case BLACK:
                return new BlackPieceFactory();
        
            case WHITE:
                return new WhitePieceFactory();
        }

        return null;
    }
}
