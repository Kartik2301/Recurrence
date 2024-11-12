package LLDQuestions.TicTacToe.Revision1.TicTacToe;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import LLDQuestions.TicTacToe.Revision1.TicTacToe.Board.Board;
import LLDQuestions.TicTacToe.Revision1.TicTacToe.Board.Cell;
import LLDQuestions.TicTacToe.Revision1.TicTacToe.Piece.OPiece;
import LLDQuestions.TicTacToe.Revision1.TicTacToe.Piece.Piece;
import LLDQuestions.TicTacToe.Revision1.TicTacToe.Piece.XPiece;

public class CentralGameClass {
    private Board board;
    private Deque<Player> players;

    public CentralGameClass(int n) {
        board = new Board(n);
        players = new ArrayDeque<>();
        
        int counter = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Cell cell = new Cell(counter++);
                cell.setPiece(null);
                board.set(i, j, cell);
            }
        }
    }

    public void setupPlayers(String playerName1, String playerName2) {
        Player player1 = new Player(playerName1);
        player1.setPiece(new XPiece());

        Player player2 = new Player(playerName2);
        player2.setPiece(new OPiece());

        players.offer(player1);
        players.offer(player2);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            // Turn Of:
            Player player = players.pollFirst();
            int row, col;

            do {
                System.out.println("Player: " + player.getUserName() + ", Make your move");
                row = scanner.nextInt();
                col = scanner.nextInt();
            } while(board.isFilled(row, col) == true);

            Cell cell = board.getCell(row, col);
            cell.setPiece(player.getPiece());
            board.set(row, col, cell);

            // Do We have a winner
            if(checkRowForEquality(row, col) || 
               checkColForEquality(row, col) ||
               checkDiagonalForEqality(row, col)) {
                // Yes we do
                System.out.println("Player: " + player.getUserName() + " is the Winner");
                break;
            }
            players.addLast(player);
        }
        
        scanner.close();
    }

    private boolean checkRowForEquality(int row, int col) {
        Piece piece = board.getCell(row, col).getPiece();
        for(int j = 0; j < board.getBoardSize(); j++) {
            if(board.getCell(row, j).getPiece() != piece) {
                return false;
            }
        }
        return true;
    }


    private boolean checkColForEquality(int row, int col) {
        Piece piece = board.getCell(row, col).getPiece();
        for(int i = 0; i < board.getBoardSize(); i++) {
            if(board.getCell(i, col).getPiece() != piece) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLeftDiagonal(int row, int col) {
        Piece piece = board.getCell(row, col).getPiece();
        
        int x = row;
        int y = col;
        int count = 0;

        // Top Left
        while(x >= 0 && y >= 0) {
            if(board.getCell(x, y).getPiece() != piece) {
                return false;
            } else count++;
            x--;
            y--;
        }

        // Bottom Right
        x = row;
        y = col;
        while(x < board.getBoardSize() && y < board.getBoardSize()) {
            if(board.getCell(x, y).getPiece() != piece) {
                return false;
            } else count++;
            x++;
            y++;
        }

        return --count == board.getBoardSize();
    }

    private boolean checkRightDiagonal(int row, int col) {
        Piece piece = board.getCell(row, col).getPiece();
        
        int x = row;
        int y = col;
        int count = 0;


        // Top Right
        while(x >= 0 && y < board.getBoardSize()) {
            if(board.getCell(x, y).getPiece() != piece) {
                return false;
            } else count++;
            x--;
            y++;
        }

        // Bottom Left
        x = row;
        y = col;

        while(x < board.getBoardSize() && y >= 0) {
            if(board.getCell(x, y).getPiece() != piece) {
                return false;
            } else count++;
            x++;
            y--;
        }

        return --count == board.getBoardSize();
    }


    private boolean checkDiagonalForEqality(int row, int col) {
        return checkLeftDiagonal(row, col) || checkRightDiagonal(row, col);
    }
}
