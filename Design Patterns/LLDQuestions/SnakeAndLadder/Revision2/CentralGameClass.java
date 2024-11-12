package LLDQuestions.SnakeAndLadder.Revision2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import LLDQuestions.SnakeAndLadder.Revision2.Board.Board;
import LLDQuestions.SnakeAndLadder.Revision2.Movables.Color;
import LLDQuestions.SnakeAndLadder.Revision2.Movables.Piece;

public class CentralGameClass {
    private Board board;
    private Deque<Player> players;
    private Dice dice;
    private int boardSize;

    public CentralGameClass(int n) {
        board = new Board(n);
        players = new ArrayDeque<>();
        dice = new Dice();
        this.boardSize = n;

        this.board.setupTraps();
        this.board.printBoard();
    }

    public void setUpPlayers(String [] userNames) {
        Piece [] pieces = new Piece[userNames.length];
        pieces[0] = new Piece(Color.RED);
        pieces[1] = new Piece(Color.BLACK);
        pieces[2] = new Piece(Color.BLUE);
        pieces[3] = new Piece(Color.YELLOW);

        for(int i = 0; i < userNames.length; i++) {
            Player player = new Player(userNames[i]);
            player.setPosition(0);
            player.setPiece(pieces[i]);
            players.addLast(player);

            board.setPieceAt(player.getPiece(), 0);
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            Player player = players.pollFirst();
            System.out.println("Player: " + player.getUserName() + " Currently at: " + player.getPosition() + " Roll the Dice");
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int delta = dice.rollDice();
            System.out.println("Die Rolls and the result is: " + delta);
            
            int newPosition = player.getPosition() + delta;
            if(newPosition >= (boardSize * boardSize) - 1) {
                System.out.println("Player: " + player.getUserName() + " Has Won the Game");
                break;
            }

            newPosition = board.newPosition(newPosition);

            player.setPosition(newPosition);
            board.setPieceAt(player.getPiece(), newPosition);
            players.addLast(player);
            
        }
        scanner.close();
    }
}
