package LLDQuestions.SnakeAndLadder.Revision1.SnakeAndLadders.CentralGameClass;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import LLDQuestions.SnakeAndLadder.Revision1.SnakeAndLadders.Board.Board;
import LLDQuestions.SnakeAndLadder.Revision1.SnakeAndLadders.Dice.Dice;
import LLDQuestions.SnakeAndLadder.Revision1.SnakeAndLadders.Player.Player;

public class CentralGameClass {
    private Board board;
    private Dice dice;
    private Deque<Player> players;
    private Player winner;
    private int boardSize;

    public CentralGameClass(int boardSize) {
        this.boardSize = boardSize;
        initializeGame();
    }

    public void initializeGame() {
        board = new Board(boardSize, 4, 5);
        dice = new Dice(1);
        winner = null;
        players = new LinkedList<>();
        addPlayers();
    }

    public void addPlayers() {
        Player player1 = new Player("James", 1);
        Player player2 = new Player("Kellogs", 1);
        Player player3 = new Player("Herman Jordan", 1);

        players.add(player1);
        players.add(player2);
        players.add(player3);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (winner == null) {
            Player player = players.pollFirst();

            System.out.println("Player: " + player.getUserName() + " current position: " + player.getCurrentPosition() + " make your move.");

            int moveDelta = dice.rollDice();

            int curPlayerPosition = player.getCurrentPosition();
            int destinationCell = board.getDestinationCell(curPlayerPosition, moveDelta);

            player.setCurrentPosition(destinationCell);
            System.out.println("Player: " + player.getUserName() + " is at position: " + player.getCurrentPosition());

            if(destinationCell == boardSize * boardSize) {
                winner = player;
                System.out.println("We have a winner it's player: " + winner.getUserName());
            }

            players.addLast(player);
            System.out.println();
        }
        scanner.close();
    }
}
