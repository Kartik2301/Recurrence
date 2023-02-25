void solve(int m[MAX][MAX], vector<string> & path, int n, int x, int y, string s) {
    if(x < 0 || x >= n || y < 0 || y >= n || m[x][y] == 0) return;
    if(x == (n-1) && y == (n-1)) {
        path.push_back(s);
        return;
    } 
    m[x][y] = 0;
    solve(m,path,n,x-1,y,s+"U");
    solve(m,path,n,x,y-1,s+"L");
    solve(m,path,n,x,y+1,s+"R");
    solve(m,path,n,x+1,y,s+"D");
    m[x][y] = 1;
}
vector<string> printPath(int m[MAX][MAX], int n) {
    // Your code goes here
    vector<string> path;
    solve(m, path, n,0,0,"");
    sort(path.begin(), path.end());
    return path;
}

Time Complexity: O(2^(n^2)).
The recursion can run upperbound 2^(n^2) times.
Space Complexity: O(n^2).
Output matrix is required so an extra space of size n*n is needed.
