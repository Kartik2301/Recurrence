package LLDQuestions.SnakeAndLadder.Revision1.SnakeAndLadders.Board;

import java.util.Random;

import LLDQuestions.SnakeAndLadder.Revision1.SnakeAndLadders.Cell.Cell;
import LLDQuestions.SnakeAndLadder.Revision1.SnakeAndLadders.Jump.Jump;

public class Board {
    private int boardSize;
    private Cell [][] playingBoard;

    public Board(int boardSize, int snakeCount, int ladderCount) {
        this.boardSize = boardSize;
        
        initializeBoard();
        addSnakesAndLadders(snakeCount, ladderCount);
    }

    public void initializeBoard() {
        playingBoard = new Cell[boardSize][boardSize];

        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++) {
                playingBoard[i][j] = new Cell();
            }
        }
    }

    private Cell getCell(int position) {
        if(position > boardSize * boardSize) {
            return null;
        }
        
        int rowNumberFromBottom = position / 10;
        if(position % boardSize != 0) {
            rowNumberFromBottom++;
        }

        int rowNumberFromTop = boardSize - rowNumberFromBottom + 1;
        int rowIndex = rowNumberFromTop - 1;
        int colIndex = (position - 1) % boardSize;
        return playingBoard[rowIndex][colIndex];
    }

    public void addSnakesAndLadders(int snakeCount, int ladderCount) {
        Random random = new Random();
        while(snakeCount > 0) {
            int snakeHead = random.nextInt(playingBoard.length * playingBoard.length) + 1;
            int snakeTail = random.nextInt(playingBoard.length * playingBoard.length) + 1;

            if(snakeTail >= snakeHead) {
                continue;
            }

            snakeCount--;

            Jump jump = new Jump(snakeHead, snakeTail);
            Cell cell = getCell(snakeHead);
            cell.setJump(jump);
        }

        while(ladderCount > 0) {
            int ladderHead = random.nextInt(playingBoard.length * playingBoard.length) + 1;
            int ladderTail = random.nextInt(playingBoard.length * playingBoard.length) + 1;

            if(ladderTail <= ladderHead) {
                continue;
            }

            ladderCount--;

            Jump jump = new Jump(ladderHead, ladderTail);
            Cell cell = getCell(ladderHead);
            cell.setJump(jump);
        }
    }

    public int getDestinationCell(int curPlayerPosition, int moveDelta) {
        int newPosition = curPlayerPosition + moveDelta;
        Cell cell = getCell(newPosition);

        if(cell == null) {
            return curPlayerPosition;
        }
        
        if(cell.getJump() != null) {
            newPosition = cell.getJump().getEndPosition();
        }
        return newPosition;
    }
}
