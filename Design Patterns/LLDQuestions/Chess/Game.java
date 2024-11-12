package LLDQuestions.Chess;

import LLDQuestions.Chess.Board.Board;
import LLDQuestions.Chess.Player.Player;

public class Game {
    private static Board board;
    private static Player player1;
    private static Player player2;

    public static void main(String[] args) {
        board = new Board(8);
        player1 = new Player("James", Color.BLACK, PieceFactoryDispatcher.createPieceFactory(Color.BLACK));
        player2 = new Player("George", Color.WHITE, PieceFactoryDispatcher.createPieceFactory(Color.WHITE));

        System.out.println(player1.getUserName() + ", " + player1.getColor());
        player1.displayInvetory();
        
        System.out.println();
        System.out.println(player2.getUserName() + ", " + player2.getColor());
        player2.displayInvetory();

        System.out.println(player1.getInventoryController().getInventory().getKing().isAValidMove(1, 1, 2, 2, 8));
    }
}
