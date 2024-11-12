package LLDQuestions.TicTacToe.Revision2.TicTacToe.Board;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.TicTacToe.Revision2.TicTacToe.Pair;
import LLDQuestions.TicTacToe.Revision2.TicTacToe.PieceType;
import LLDQuestions.TicTacToe.Revision2.TicTacToe.Pieces.PlayingPiece;

public class PlayingBoard {
    private int size;
    private PlayingPiece [][] board;

    public PlayingBoard(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int xCoordinate, int yCoordinate, PlayingPiece playingPiece) {
        if(xCoordinate < 0 || yCoordinate < 0 || xCoordinate >= size || yCoordinate >= size) {
            return false;
        }

        if(board[xCoordinate][yCoordinate] != null) {
            return false;
        }

        board[xCoordinate][yCoordinate] = playingPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null) {
                    freeCells.add(new Pair<Integer,Integer>(i, j));
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null) {
                    System.out.print("_" + " ");
                } else {
                    switch (board[i][j].getPieceType()) {
                        case TypeO:
                            System.out.print("O" + " ");
                            break;
                        
                        case TypeX:
                            System.out.print("X" + " ");
                            break;
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int isGameOver(int xCoordinate, int yCoordinate, PieceType pieceType) {
        boolean allSameInRow = true;
        for(int j = 0; j < size; j++) {
            if(board[xCoordinate][j] == null) {
                allSameInRow = false;
                break;
            }
            if(board[xCoordinate][j].getPieceType() != pieceType) {
                allSameInRow = false;
                break;
            }
        }

        if(allSameInRow) return 1;

        boolean allSameInCol = true;
        for(int i = 0; i < size; i++) {
            if(board[i][yCoordinate] == null) {
                allSameInCol = false;
                break;
            }
            if(board[i][yCoordinate].getPieceType() != pieceType) {
                allSameInCol = false;
                break;
            }
        }

        if(allSameInCol) return 1;

        if(getFreeCells().size() == 0) {
            return 2;
        }

        return 0;
    }
}
