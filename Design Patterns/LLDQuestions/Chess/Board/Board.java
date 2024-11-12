package LLDQuestions.Chess.Board;

import LLDQuestions.Chess.Cell.Cell;

public class Board {
    private Cell[][] board;
    private int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        
        board = new Cell[boardSize][boardSize];
    }
}
