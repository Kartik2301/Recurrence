class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        vector<vector<bool>> visited(image.size(), vector<bool> (image[0].size(), false));
        solve(image,sr,sc,image[sr][sc], newColor, visited);
        return image;
    }
    void solve(vector<vector<int>>& image, int sr, int sc, int color, int newColor,  vector<vector<bool>> & visited) {
        if(sr < 0 || sc < 0 || sr >= image.size() || sc >= image[0].size()) return;
        if(image[sr][sc] != color) return;
        if(visited[sr][sc]) return;
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        solve(image,sr-1,sc,color,newColor,visited);
        solve(image,sr+1,sc,color,newColor,visited);
        solve(image,sr,sc+1,color,newColor,visited);
        solve(image,sr,sc-1,color,newColor,visited);
    }
};