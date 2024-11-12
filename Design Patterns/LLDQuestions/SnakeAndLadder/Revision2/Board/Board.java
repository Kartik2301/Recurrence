package LLDQuestions.SnakeAndLadder.Revision2.Board;

import java.util.Random;

import LLDQuestions.SnakeAndLadder.Revision2.Movables.Piece;
import LLDQuestions.SnakeAndLadder.Revision2.Movables.PositionChangers;

public class Board {
    private Cell[][] board;

    public Board(int n) {
        board = new Cell[n][n];

        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Cell cell = new Cell();
                cell.setPosition(count++);
                board[i][j] = cell;
            }
        }
    }

    public void setupTraps() {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j].getPosition() == 0 || board[i][j].getPosition() == (board.length * board.length) - 1) {
                    count++;
                    continue;
                }

                Random random = new Random();
                
                if(random.nextInt(3) == 0) {
                    int destination;
                    do { 
                        destination = random.nextInt(board.length * board.length);
                    } while(destination == count);

                    board[i][j].setPositionChanger(new PositionChangers(destination));
                }
                
                count++;
            }
        }
    }

    public void printBoard() {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j].getPositionChanger() != null) {
                    System.out.print(board[i][j].getPositionChanger().getDestination() + " ");
                } else {
                    System.out.print(count + " ");
                }
                count++;
            }
            System.out.println();
        }
    }

    public void setPieceAt(Piece piece, int position) {
        int row = position / board.length;
        int col = position % board.length;
        board[row][col].setPiece(piece);
    }

    public int newPosition(int position) {
        int row = position / board.length;
        int col = position % board.length;

        if(board[row][col].getPositionChanger() == null) {
            return position;
        }

        return board[row][col].getPositionChanger().getDestination();
    }
}
