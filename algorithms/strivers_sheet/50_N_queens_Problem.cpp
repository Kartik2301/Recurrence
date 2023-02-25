Solution 1 :-
Naive solution
The first idea is to use brute-force that means to generate all possible ways to put N queens on the board, 
and then check them to keep only the combinations with no queen under attack. That means O(N^N)

Solution 2 :- Backtracking
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> board = new ArrayList<>();
        boolean [][] visited = new boolean[n][n];
        int i,j;
        for(i=0;i<n;i++) {
            for(j=0;j<n;j++) {
                visited[i][j] = false;
            }
        }
        solve(board,n,-1,visited);
        return board;
    }
    public boolean isValid(int row, int col, boolean [][] visited, int n) {
        int i,j;
        for(i=0;i<n;i++) {
            if(visited[i][col]) return false;
        }
        for(j=0;j<n;j++) {
            if(visited[row][j]) return false;
        }
        for(i=row,j=col;i>=0 && j>=0; i--,j--) {
            if(visited[i][j]) return false;
        }
        for(i=row,j=col;i>=0 && j<n; i--,j++) {
            if(visited[i][j]) return false;
        }
        return true;
    }
    public boolean solve(List<List<String>> board, int n, int row, boolean [][] visited) {
        if(row == n-1) {
            List<String> list = new ArrayList<>();
            int i,j;
            for(i=0;i<n;i++) {
                String temp = "";
                for(j=0;j<n;j++) {
                    if(visited[i][j]) {
                        temp += "Q";
                    } else {
                        temp += ".";
                    }
                }
                list.add(temp);
            }
            board.add(list);
            return true;
        } else {
            int newRow = row+1;
            for(int col=0;col<n;col++) {
                if(isValid(newRow,col, visited,n)) {
                    visited[newRow][col] = true;
                    solve(board,n,newRow,visited);
                    visited[newRow][col] = false;
                }
            }
        }
        return false;
    }
}

Time complexity :O(N!). There is N possibilities to put the first queen, not more than N (N - 2) to put the second one, 
not more than N(N - 2)(N - 4) for the third one etc. In total that results in O(N!) time complexity.
Space complexity : O(N*N) to keep an information about diagonals and rows