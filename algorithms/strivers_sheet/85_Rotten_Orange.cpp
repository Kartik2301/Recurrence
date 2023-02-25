class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        queue<pair<int,int>> q;
        int i;
        int n = grid.size();
        if(n == 0) return -1;
        int m = grid[0].size();
        int freshCount = 0;
        for(i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 2) {
                    q.push({i-1,j});
                    q.push({i,j-1});
                    q.push({i,j+1});
                    q.push({i+1,j});
                } else if(grid[i][j] == 1) freshCount++;
            }
        }
        if(freshCount == 0) return 0;
        vector<vector<bool>> visited(n, vector<bool> (m, false));
        int level = 0;
        while(!q.empty()) {
            int size = q.size();
            while(size--) {
                int x = q.front().first;
                int y = q.front().second;
                q.pop();
                if(x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] && grid[x][y] == 1) {
                    visited[x][y] = true;
                    grid[x][y] = 2;
                    q.push({x-1,y});
                    q.push({x+1,y});
                    q.push({x,y-1});
                    q.push({x,y+1});
                }
            }
            level++;
        }
        for(i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return level-1;
    }
};