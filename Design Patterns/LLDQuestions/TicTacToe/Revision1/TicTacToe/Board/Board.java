package LLDQuestions.TicTacToe.Revision1.TicTacToe.Board;

public class Board {
    private Cell[][] board;
    int boardSize;

    public Board(int n) {
        boardSize = n;
        board = new Cell[n][n];
    }

    public boolean isFilled(int x, int y) {
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) return true;
        return board[x][y].getPiece() != null;
    }

    public void set(int x, int y, Cell cell) {
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;
        board[x][y] = cell;
    }

    public Cell getCell(int x, int y) {
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) return null;
        return board[x][y];
    }

    public int getBoardSize() {
        return boardSize;
    }
}
