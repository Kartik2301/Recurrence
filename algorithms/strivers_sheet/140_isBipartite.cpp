class Solution {
public:
    bool isBipartite(vector<vector<int>>& graph) {
        int i;
        int m = graph.size();
        vector<int> color(m, -1);
        for(i=0;i<graph.size();i++) {
            queue<int> q;
            if(color[i] != -1) continue;
            q.push(i);
            color[i] = 1;
            while(!q.empty()) {
                int s = q.front();
                q.pop();
                for(int j=0;j<graph[s].size();j++) {
                    if(color[graph[s][j]] == -1) {
                        color[graph[s][j]] = 1 - color[s];
                        q.push(graph[s][j]);
                    } else if(color[graph[s][j]] != -1 && color[graph[s][j]] == color[s]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
};