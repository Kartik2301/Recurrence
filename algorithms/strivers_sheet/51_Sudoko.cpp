Solution 1 :-
Naive methods


Solution 2 :- 
Backtracking

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    int [] contains_unassigned_pos(char [][] board) {
        int i,j;
        int [] res = new int[2];
        for(i=0;i<board.length;i++) {
            for(j=0;j<board[0].length;j++) {
                if(board[i][j] == '.') {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        res[0] = -1;
        res[1] = -1;
        return res;
    }
    boolean safeRow(int x, int y, char ch, char [][] board) {
        int j;
        for(j=0;j<board[0].length;j++) {
            if(board[x][j] == ch) return false;
        }
        return true;
    }
    
    boolean safeCol(int x, int y, char ch, char [][] board) {
        int i;
        for(i=0;i<board.length;i++) {
            if(board[i][y] == ch) return false;
        }
        return true;
    }
    boolean safeBox(int x, int y, char ch, char [][] board) {
        int i,j;
        for(i=0;i<3;i++) {
            for(j=0;j<3;j++) {
                if(board[x+i][y+j] == ch) return false;
            }
        }
        return true;
    }
    boolean isValid(int x, int y, char ch, char [][] board) {
        return safeRow(x,y,ch,board) && safeCol(x,y,ch,board) && safeBox(x-x%3,y-y%3,ch,board);
    }
    public boolean solve(char [][] board) {
        int [] position = contains_unassigned_pos(board);
        if(position[0] == -1) return true;
        int x = position[0];
        int y = position[1];
        for(int i=1;i<=9;i++){
            char ch = (char) ('0' + i);
            if(isValid(x,y,ch,board)) {
                board[x][y] = ch;
                if(solve(board)) return true;
                board[x][y] = '.';
            }
        }
        return false;
    }
}

Time complexity: O(9^(n*n)). 
For every unassigned index, there are 9 possible options so the time complexity is 
O(9^(n*n)). The time complexity remains the same but there will be some early pruning so the 
time taken will be much less than the naive algorithm but the upper bound time complexity remains the same.
Space Complexity: O(n*n). 
To store the output array a matrix is needed.