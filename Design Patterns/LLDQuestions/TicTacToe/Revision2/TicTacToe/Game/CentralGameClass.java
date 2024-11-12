package LLDQuestions.TicTacToe.Revision2.TicTacToe.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import LLDQuestions.TicTacToe.Revision2.TicTacToe.PieceType;
import LLDQuestions.TicTacToe.Revision2.TicTacToe.Board.PlayingBoard;
import LLDQuestions.TicTacToe.Revision2.TicTacToe.Pieces.PlayingPieceO;
import LLDQuestions.TicTacToe.Revision2.TicTacToe.Pieces.PlayingPieceX;
import LLDQuestions.TicTacToe.Revision2.TicTacToe.Player.Player;

public class CentralGameClass {
    private PlayingBoard playingBoard;
    private List<Player> players;
    private int boardSize;
    private int playersCount;

    private void setupGame() {
        playingBoard = new PlayingBoard(boardSize);
        players = new ArrayList<>();

        // Create players
        Player player1 = new Player("James", new PlayingPieceX());
        Player player2 = new Player("Kellogs", new PlayingPieceO());

        players.add(player1);
        players.add(player2);
    }
    
    public CentralGameClass(int boardSize, int playersCount) {
        this.boardSize = boardSize;
        this.playersCount = playersCount;
        setupGame();
    }

    public void startGame() {
        int gameStatus = 0; // unfinished

        Scanner scanner = new Scanner(System.in);
        while(gameStatus == 0) {
            for(Player player: players) {
                System.out.println("Player: " + player.getUserName() + " Make your move, now!!");

                int xCoordinate = scanner.nextInt();
                int yCoordinate = scanner.nextInt();

                while(playingBoard.addPiece(xCoordinate, yCoordinate, player.getPlayingPiece()) == false) {
                    System.out.println("Player: " + player.getUserName() + " Cell you have selected is not available, choose again");
                    xCoordinate = scanner.nextInt();
                    yCoordinate = scanner.nextInt();
                }

                playingBoard.printBoard();
                
                gameStatus = checkGameStatus(xCoordinate, yCoordinate, player.getPlayingPiece().getPieceType());

                if(gameStatus == 1) {
                    System.out.println("We have a winner, it's Player: " + player.getUserName());
                } else if(gameStatus == 2) {
                    System.out.println("Game Over, It's a tie");
                }

                if(gameStatus > 0) {
                    break;
                }
            }
        }
        scanner.close();
    }

    public int checkGameStatus(int xCoordinate, int yCoordinate, PieceType pieceType) {
        return playingBoard.isGameOver(xCoordinate, yCoordinate, pieceType);
    }
}
