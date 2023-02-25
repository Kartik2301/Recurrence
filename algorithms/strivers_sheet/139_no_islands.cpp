class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int m = grid.size();
        if(m == 0) return 0;
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool> (n, false));
        int i,j;
        int count = 0;
        for(i=0;i<m;i++) {
            for(j=0;j<n;j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(vector<vector<char>>& grid, vector<vector<bool>> & visited, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.size() || col >= grid[0].size() || visited[row][col] || grid[row][col] == '0') return;
        visited[row][col] = true;
        dfs(grid,visited,row-1,col);
        dfs(grid,visited,row+1,col);
        dfs(grid,visited,row,col+1);
        dfs(grid,visited,row,col-1);
    }
};